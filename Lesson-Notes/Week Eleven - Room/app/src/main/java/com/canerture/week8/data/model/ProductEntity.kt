package com.canerture.week8.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int? = null,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "imageUrl")
    val imageUrl: String,

    @ColumnInfo(name = "price")
    val price: Double,

    @ColumnInfo(name = "title")
    val title: String
) {
    fun mapToProductUI(): ProductUI {
        return ProductUI(
            id = id ?: 1,
            title = title,
            description = description,
            imageUrl = imageUrl,
            price = price
        )
    }
}