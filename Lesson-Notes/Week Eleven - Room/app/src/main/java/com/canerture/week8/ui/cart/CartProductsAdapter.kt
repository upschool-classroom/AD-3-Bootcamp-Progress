package com.canerture.week8.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.canerture.week8.common.loadImage
import com.canerture.week8.data.model.ProductUI
import com.canerture.week8.databinding.ItemCartProductBinding

/**
 * Created on 10.08.2023
 * @author Caner Türe
 */

class CartProductsAdapter(
    private val cartProductListener: CartProductListener
) : ListAdapter<ProductUI, CartProductsAdapter.CartProductViewHolder>(ProductDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartProductViewHolder =
        CartProductViewHolder(
            ItemCartProductBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            cartProductListener
        )

    override fun onBindViewHolder(holder: CartProductViewHolder, position: Int) = holder.bind(getItem(position))

    class CartProductViewHolder(
        private val binding: ItemCartProductBinding,
        private val cartProductListener: CartProductListener
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(product: ProductUI) = with(binding) {
            tvTitle.text = product.title
            tvPrice.text = "${product.price} ₺"

            ivProduct.loadImage(product.imageUrl)

            root.setOnClickListener {
                cartProductListener.onProductClick(product.id)
            }

            ivDelete.setOnClickListener {
                cartProductListener.onDeleteClick(product)
            }
        }
    }

    class ProductDiffCallBack : DiffUtil.ItemCallback<ProductUI>() {
        override fun areItemsTheSame(oldItem: ProductUI, newItem: ProductUI): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProductUI, newItem: ProductUI): Boolean {
            return oldItem == newItem
        }
    }

    interface CartProductListener {
        fun onProductClick(id: Int)
        fun onDeleteClick(product: ProductUI)
    }
}