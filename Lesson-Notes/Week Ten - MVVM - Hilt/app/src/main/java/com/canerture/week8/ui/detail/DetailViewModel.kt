package com.canerture.week8.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.canerture.week8.data.model.Product
import com.canerture.week8.data.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val productsRepository: ProductsRepository) : ViewModel() {

    private var _productDetailLiveData = MutableLiveData<Product?>()
    val productDetailLiveData: LiveData<Product?>
        get() = _productDetailLiveData

    private var _errorMessageLiveData = MutableLiveData<String>()
    val errorMessageLiveData: LiveData<String>
        get() = _errorMessageLiveData

    private var _loadingLiveData = MutableLiveData<Boolean>()
    val loadingLiveData: LiveData<Boolean>
        get() = _loadingLiveData

    init {
        _productDetailLiveData = productsRepository.productDetailLiveData
        _errorMessageLiveData = productsRepository.errorMessageLiveData
        _loadingLiveData = productsRepository.loadingLiveData
    }

    fun getProductDetail(id: Int) {
        productsRepository.getProductDetail(id)
    }
}