package com.canerture.week8.data.model

import com.google.gson.annotations.SerializedName

data class Product(
    val description: String?,
    val id: Int?,
    @SerializedName("image_url") val imageUrl: String?,
    val price: Double?,
    val title: String?
) {
    fun mapToProductUI(): ProductUI {
        return ProductUI(
            id = id ?: 1,
            title = title.orEmpty(),
            description = description.orEmpty(),
            imageUrl = imageUrl.orEmpty(),
            price = price ?: 0.0
        )
    }
}