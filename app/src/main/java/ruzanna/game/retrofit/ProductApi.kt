package ruzanna.game.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {
    @GET("public-api/products/{productId}")
    fun getProduct(@Path("productId")productId:String): Call<MainResponse>
}