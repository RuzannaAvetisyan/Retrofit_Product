package ruzanna.game.retrofit

import com.google.gson.annotations.SerializedName

class Product(
    @SerializedName("id") var id: Int,
    @SerializedName("name") var name: String,
    @SerializedName("description") var description: String,
    @SerializedName("price") var price: Float,
    @SerializedName("discount_amount") var discount: Float
)