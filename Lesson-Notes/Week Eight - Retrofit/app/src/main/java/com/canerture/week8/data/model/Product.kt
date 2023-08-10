package com.canerture.week8.data.model

import com.google.gson.annotations.SerializedName

data class Product(
    val description: String?,
    val id: Int?,
    @SerializedName("image_url") val imageUrl: String?,
    val price: Double?,
    val title: String?
)