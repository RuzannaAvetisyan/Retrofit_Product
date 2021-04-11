package ruzanna.game.retrofit

import com.google.gson.annotations.SerializedName

class MainResponse(
    @SerializedName("code") var code: Int,
    @SerializedName("data") var product: Product
)