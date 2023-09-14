package com.canerture.week8.data.source.remote

import com.canerture.week8.common.Constants.Endpoint.GET_PRODUCTS
import com.canerture.week8.common.Constants.Endpoint.GET_PRODUCT_DETAIL
import com.canerture.week8.data.model.GetProductDetailResponse
import com.canerture.week8.data.model.GetProductsResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface ProductService {

    @GET(GET_PRODUCTS)
    suspend fun getProducts(): GetProductsResponse

    @POST(GET_PRODUCT_DETAIL)
    @FormUrlEncoded
    suspend fun getProductDetail(
        @Field("id") id: Int
    ): GetProductDetailResponse
}