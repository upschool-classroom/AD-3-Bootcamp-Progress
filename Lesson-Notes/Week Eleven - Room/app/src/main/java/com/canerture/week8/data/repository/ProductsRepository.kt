package com.canerture.week8.data.repository

import com.canerture.week8.common.Resource
import com.canerture.week8.data.model.ProductUI
import com.canerture.week8.data.source.local.ProductDao
import com.canerture.week8.data.source.remote.ProductService

class ProductsRepository(
    private val productService: ProductService,
    private val productDao: ProductDao
) {

    suspend fun getProducts(): Resource<List<ProductUI>> {
        return try {
            Resource.Success(productService.getProducts().products?.map { it.mapToProductUI() }.orEmpty())
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }

    suspend fun getProductDetail(id: Int): Resource<ProductUI> {
        return try {
            productService.getProductDetail(id).product?.let {
                Resource.Success(it.mapToProductUI())
            } ?: kotlin.run {
                Resource.Error(Exception("Product not found"))
            }
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }

    suspend fun addProductToCart(product: ProductUI) {
        productDao.addProduct(product.mapToProductEntity())
    }

    suspend fun deleteProductFromCart(product: ProductUI) {
        productDao.deleteProduct(product.mapToProductEntity())
    }

    suspend fun getCartProducts(): Resource<List<ProductUI>> {
        return try {
            Resource.Success(productDao.getProducts().map { it.mapToProductUI() })
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }
}