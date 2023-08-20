package com.canerture.week8.data.model

import com.google.gson.annotations.SerializedName

data class Product(
    val id: Int,
    val category: String,
    val count: Int,
    val description: String,
    val image: String,
    @SerializedName("image_two")
    val imageTwo: String,
    @SerializedName("image_three")
    val imageThree: String,
    val price: Double,
    val rate: Double,
    val title: String,
    @SerializedName("sale_state")
    val saleState: Int
)