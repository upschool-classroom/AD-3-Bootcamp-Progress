package com.canerture.week8.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.canerture.week8.MainApplication
import com.canerture.week8.R
import com.canerture.week8.common.loadImage
import com.canerture.week8.common.viewBinding
import com.canerture.week8.data.model.GetProductDetailResponse
import com.canerture.week8.data.model.GetProductsResponse
import com.canerture.week8.data.model.Product
import com.canerture.week8.databinding.FragmentDetailBinding
import com.canerture.week8.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created on 10.08.2023
 * @author Caner Türe
 */

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val binding by viewBinding(FragmentDetailBinding::bind)

    private val args by navArgs<DetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getProductDetail(args.id)
    }

    private fun getProductDetail(id: Int) {
        MainApplication.productService?.getProductDetail(id)?.enqueue(object : Callback<Product> {
            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                val result = response.body()

                if (result != null) {
                    with(binding) {
                        tvTitle.text = result.title
                        tvDescription.text = result.description
                        tvPrice.text = "${result.price} ₺"
                        ivProduct.loadImage(result.image)
                    }
                }
            }

            override fun onFailure(call: Call<Product>, t: Throwable) {
                Log.e("GetProducts", t.message.orEmpty())
            }
        })
    }
}