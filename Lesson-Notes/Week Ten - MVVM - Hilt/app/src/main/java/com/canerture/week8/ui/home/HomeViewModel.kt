package com.canerture.week8.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.canerture.week8.data.model.Product
import com.canerture.week8.data.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val productsRepository: ProductsRepository) : ViewModel() {

    private var _productsLiveData = MutableLiveData<List<Product>?>()
    val productsLiveData: LiveData<List<Product>?>
        get() = _productsLiveData

    private var _errorMessageLiveData = MutableLiveData<String>()
    val errorMessageLiveData: LiveData<String>
        get() = _errorMessageLiveData

    private var _loadingLiveData = MutableLiveData<Boolean>()
    val loadingLiveData: LiveData<Boolean>
        get() = _loadingLiveData

    init {
        _productsLiveData = productsRepository.productsLiveData
        _errorMessageLiveData = productsRepository.errorMessageLiveData
        _loadingLiveData = productsRepository.loadingLiveData
    }

    fun getProducts() {
        productsRepository.getProducts()
    }
}