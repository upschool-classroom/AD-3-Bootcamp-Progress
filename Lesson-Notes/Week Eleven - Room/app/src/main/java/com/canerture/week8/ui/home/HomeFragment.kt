package com.canerture.week8.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.canerture.week8.R
import com.canerture.week8.common.gone
import com.canerture.week8.common.viewBinding
import com.canerture.week8.common.visible
import com.canerture.week8.data.model.ProductUI
import com.canerture.week8.databinding.FragmentHomeBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created on 10.08.2023
 * @author Caner Türe
 */

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home), ProductsAdapter.ProductListener {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    private val viewModel by viewModels<HomeViewModel>()

    private val productsAdapter by lazy { ProductsAdapter(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvProducts.adapter = productsAdapter

        observeData()
    }

    private fun observeData() = with(binding) {
        viewModel.mainState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is MainState.Loading -> {
                    progressBar.visible()
                }

                is MainState.Success -> {
                    productsAdapter.submitList(state.products)
                    progressBar.gone()
                }

                is MainState.Error -> {
                    ivError.visible()
                    tvError.visible()
                    tvError.text = state.throwable.message.orEmpty()
                    progressBar.gone()
                }
            }
        }
    }

    override fun onProductClick(id: Int) {
        val action = HomeFragmentDirections.homeToDetail(id)
        findNavController().navigate(action)
    }

    override fun onAddToCartClick(product: ProductUI) {
        viewModel.addProductToCart(product)
        Snackbar.make(requireView(), "Ürün sepete eklendi.", Snackbar.LENGTH_SHORT).show()
    }
}