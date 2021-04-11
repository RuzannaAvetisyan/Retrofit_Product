package ruzanna.game.retrofit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_dialog.*

class GetProductIDFragment : DialogFragment(){

    lateinit var listener: GetProductIDListener


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        get_product.setOnClickListener {
            if(input_id.text.toString() != ""){

                listener.getProductIDListener(input_id.text.toString(), this)
            }
        }
    }


    interface GetProductIDListener {
        fun getProductIDListener(id: String, frag: GetProductIDFragment?)
    }

}
