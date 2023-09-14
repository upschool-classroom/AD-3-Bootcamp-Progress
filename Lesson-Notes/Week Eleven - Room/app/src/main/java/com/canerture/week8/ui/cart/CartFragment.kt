package com.canerture.week8.ui.cart

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
import com.canerture.week8.databinding.FragmentCartBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created on 10.08.2023
 * @author Caner Türe
 */

@AndroidEntryPoint
class CartFragment : Fragment(R.layout.fragment_cart), CartProductsAdapter.CartProductListener {

    private val binding by viewBinding(FragmentCartBinding::bind)

    private val viewModel by viewModels<CartViewModel>()

    private val cartProductsAdapter by lazy { CartProductsAdapter(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCartProducts()

        binding.rvCartProducts.adapter = cartProductsAdapter

        observeData()
    }

    private fun observeData() = with(binding) {
        viewModel.cartState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is CartState.Loading -> {
                    progressBar.visible()
                }

                is CartState.Success -> {
                    cartProductsAdapter.submitList(state.products)
                    progressBar.gone()
                }

                is CartState.Error -> {
                    ivError.visible()
                    tvError.visible()
                    tvError.text = state.throwable.message.orEmpty()
                    progressBar.gone()
                }
            }
        }
    }

    override fun onProductClick(id: Int) {
        val action = CartFragmentDirections.cartToDetail(id)
        findNavController().navigate(action)
    }

    override fun onDeleteClick(product: ProductUI) {
        viewModel.deleteProduct(product)
    }
}