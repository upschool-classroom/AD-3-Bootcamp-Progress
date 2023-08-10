package com.canerture.week8.data.model

data class GetProductsResponse(
    val code: Int?,
    val message: String?,
    val products: List<Product>?
)