package com.canerture.week8.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.canerture.week8.common.loadImage
import com.canerture.week8.data.model.ProductUI
import com.canerture.week8.databinding.ItemProductBinding

/**
 * Created on 10.08.2023
 * @author Caner Türe
 */

class ProductsAdapter(
    private val productListener: ProductListener
) : ListAdapter<ProductUI, ProductsAdapter.ProductViewHolder>(ProductDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder =
        ProductViewHolder(
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            productListener
        )

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) = holder.bind(getItem(position))

    class ProductViewHolder(
        private val binding: ItemProductBinding,
        private val productListener: ProductListener
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(product: ProductUI) = with(binding) {
            tvTitle.text = product.title
            tvPrice.text = "${product.price} ₺"

            ivProduct.loadImage(product.imageUrl)

            root.setOnClickListener {
                productListener.onProductClick(product.id)
            }

            btnAddToCart.setOnClickListener {
                productListener.onAddToCartClick(product)
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

    interface ProductListener {
        fun onProductClick(id: Int)
        fun onAddToCartClick(product: ProductUI)
    }
}