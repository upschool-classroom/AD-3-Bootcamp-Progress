package com.canerture.week8.data.model

data class ProductUI(
    val description: String,
    val id: Int,
    val imageUrl: String,
    val price: Double,
    val title: String
) {
    fun mapToProductEntity(): ProductEntity {
        return ProductEntity(
            id = id,
            title = title,
            description = description,
            imageUrl = imageUrl,
            price = price
        )
    }
}