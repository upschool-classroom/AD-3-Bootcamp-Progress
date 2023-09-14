package com.canerture.week8.ui.home

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
class HomeViewModel @Inject constructor(
    private val productRepository: ProductsRepository
) : ViewModel() {

    private var _mainState = MutableLiveData<MainState>()
    val mainState: LiveData<MainState>
        get() = _mainState

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            _mainState.value = MainState.Loading
            when (val result = productRepository.getProducts()) {
                is Resource.Success -> {
                    _mainState.value = MainState.Success(result.data)
                }

                is Resource.Error -> {
                    _mainState.value = MainState.Error(result.throwable)
                }
            }
        }
    }

    fun addProductToCart(product: ProductUI) {
        viewModelScope.launch {
            productRepository.addProductToCart(product)
        }
    }
}

sealed interface MainState {
    object Loading : MainState
    data class Success(val products: List<ProductUI>) : MainState
    data class Error(val throwable: Throwable) : MainState
}