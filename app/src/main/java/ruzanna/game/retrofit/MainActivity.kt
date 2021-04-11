package ruzanna.game.retrofit

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(), GetProductIDFragment.GetProductIDListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getProductIDListener("2", null)
        floatingActionButton.setOnClickListener{
            val getProductIDFragment = GetProductIDFragment()
            getProductIDFragment.listener = this
            getProductIDFragment.show(supportFragmentManager, "GetProductIDFragment")
        }
    }


    override fun getProductIDListener(id: String, frag: GetProductIDFragment?) {
        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Waiting for product data loading.")
        progressDialog.setMessage("Loading...")
        frag?.dismiss()
        val productApi =  ApiService.retrofit.create(ProductApi::class.java)
        val coll =  productApi.getProduct(id)

        progressDialog.show()
        coll.enqueue(object : Callback<MainResponse>{

            override fun onFailure(call: Call<MainResponse>, t: Throwable) {
            }
            override fun onResponse(call: Call<MainResponse>, response: Response<MainResponse>) {
                val newProduct = response.body()!!.product
                name.text = newProduct.name
                id_product.text = newProduct.id.toString()
                price.text = newProduct.price.toString()
                discount_amount.text = newProduct.discount.toString()
                description.text = newProduct.description
                progressDialog.dismiss()

            }
        })

    }
}
