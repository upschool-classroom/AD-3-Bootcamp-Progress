package com.canerture.week8.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canerture.week8.common.Resource
import com.canerture.week8.data.model.ProductUI
import com.canerture.week8.data.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val productRepository: ProductsRepository
) : ViewModel() {

    private var _cartState = MutableLiveData<CartState>()
    val cartState: LiveData<CartState>
        get() = _cartState

    fun getCartProducts() {
        viewModelScope.launch {
            _cartState.value = CartState.Loading
            when (val result = productRepository.getCartProducts()) {
                is Resource.Success -> {
                    _cartState.value = CartState.Success(result.data)
                }

                is Resource.Error -> {
                    _cartState.value = CartState.Error(result.throwable)
                }
            }
        }
    }

    fun deleteProduct(product: ProductUI) {
        viewModelScope.launch {
            productRepository.deleteProductFromCart(product)
            getCartProducts()
        }
    }
}

sealed interface CartState {
    object Loading : CartState
    data class Success(val products: List<ProductUI>) : CartState
    data class Error(val throwable: Throwable) : CartState
}