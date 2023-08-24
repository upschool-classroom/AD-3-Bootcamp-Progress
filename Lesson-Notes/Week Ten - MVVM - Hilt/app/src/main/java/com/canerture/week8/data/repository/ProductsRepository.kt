package com.canerture.week8.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.canerture.week8.data.model.GetProductDetailResponse
import com.canerture.week8.data.model.GetProductsResponse
import com.canerture.week8.data.model.Product
import com.canerture.week8.data.source.remote.ProductService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsRepository (private val productService: ProductService) {

    val productsLiveData = MutableLiveData<List<Product>?>()
    val productDetailLiveData = MutableLiveData<Product?>()
    val errorMessageLiveData = MutableLiveData<String>()
    val loadingLiveData = MutableLiveData<Boolean>()

    fun getProducts() {
        loadingLiveData.value = true
        productService.getProducts().enqueue(object : Callback<GetProductsResponse> {
            override fun onResponse(call: Call<GetProductsResponse>, response: Response<GetProductsResponse>) {
                val result = response.body()?.products

                if (result.isNullOrEmpty().not()) {
                    productsLiveData.value = result
                } else {
                    productsLiveData.value = null
                }

                loadingLiveData.value = false
            }

            override fun onFailure(call: Call<GetProductsResponse>, t: Throwable) {
                errorMessageLiveData.value = t.message.orEmpty()
                loadingLiveData.value = false
                Log.e("GetProducts", t.message.orEmpty())
            }
        })
    }

    fun getProductDetail(id: Int) {
        loadingLiveData.value = true
        productService.getProductDetail(id).enqueue(object : Callback<GetProductDetailResponse> {
            override fun onResponse(
                call: Call<GetProductDetailResponse>,
                response: Response<GetProductDetailResponse>
            ) {
                productDetailLiveData.value = response.body()?.product
                loadingLiveData.value = false
            }

            override fun onFailure(call: Call<GetProductDetailResponse>, t: Throwable) {
                errorMessageLiveData.value = t.message.orEmpty()
                loadingLiveData.value = false
                Log.e("GetProducts", t.message.orEmpty())
            }
        })
    }
}