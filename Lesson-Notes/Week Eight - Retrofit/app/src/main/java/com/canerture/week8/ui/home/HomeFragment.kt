package com.canerture.week8.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.canerture.week8.MainApplication
import com.canerture.week8.R
import com.canerture.week8.common.viewBinding
import com.canerture.week8.data.model.GetProductsResponse
import com.canerture.week8.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created on 10.08.2023
 * @author Caner Türe
 */

class HomeFragment : Fragment(R.layout.fragment_home), ProductsAdapter.ProductListener {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    private val productsAdapter by lazy { ProductsAdapter(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvProducts.adapter = productsAdapter
        getProducts()
    }

    private fun getProducts() {
        MainApplication.productService?.getProducts()?.enqueue(object : Callback<GetProductsResponse> {
            override fun onResponse(call: Call<GetProductsResponse>, response: Response<GetProductsResponse>) {
                val result = response.body()?.products

                if (result.isNullOrEmpty().not()) {
                    productsAdapter.submitList(result)
                }
            }

            override fun onFailure(call: Call<GetProductsResponse>, t: Throwable) {
                Log.e("GetProducts", t.message.orEmpty())
            }
        })
    }

    override fun onProductClick(id: Int) {
        val action = HomeFragmentDirections.homeToDetail(id)
        findNavController().navigate(action)
    }
}