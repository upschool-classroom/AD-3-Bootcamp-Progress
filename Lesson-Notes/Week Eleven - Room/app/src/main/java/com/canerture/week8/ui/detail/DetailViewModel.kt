package com.canerture.week8.ui.detail

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
class DetailViewModel @Inject constructor(
    private val productRepository: ProductsRepository
) : ViewModel() {

    private var _detailState = MutableLiveData<DetailState>()
    val detailState: LiveData<DetailState>
        get() = _detailState

    fun getProductDetail(id: Int) {
        viewModelScope.launch {
            _detailState.value = DetailState.Loading
            when (val result = productRepository.getProductDetail(id)) {
                is Resource.Success -> {
                    _detailState.value = DetailState.Success(result.data)
                }

                is Resource.Error -> {
                    _detailState.value = DetailState.Error(result.throwable)
                }
            }
        }
    }
}

sealed interface DetailState {
    object Loading : DetailState
    data class Success(val product: ProductUI) : DetailState
    data class Error(val throwable: Throwable) : DetailState
}