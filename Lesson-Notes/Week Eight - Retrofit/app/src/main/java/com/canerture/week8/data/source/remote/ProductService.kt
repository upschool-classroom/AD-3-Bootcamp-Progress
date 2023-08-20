package com.canerture.week8.data.source.remote

import com.canerture.week8.common.Constants.Endpoint.GET_PRODUCTS
import com.canerture.week8.common.Constants.Endpoint.GET_PRODUCT_DETAIL
import com.canerture.week8.data.model.GetProductDetailResponse
import com.canerture.week8.data.model.GetProductsResponse
import com.canerture.week8.data.model.Product
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface ProductService {

    @GET(GET_PRODUCTS)
    fun getProducts(): Call<List<Product>>

    @GET(GET_PRODUCT_DETAIL)
    fun getProductDetail(
        @Query("id") id: Int
    ): Call<Product>
}