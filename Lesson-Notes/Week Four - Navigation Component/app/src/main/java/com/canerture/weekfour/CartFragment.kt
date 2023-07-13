package com.canerture.weekfour

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.canerture.weekfour.databinding.FragmentCartBinding

class CartFragment : Fragment(R.layout.fragment_cart) {

    private val binding by viewBinding(FragmentCartBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnGoToProfile.setOnClickListener {
                val action = CartFragmentDirections.cartToProfile("Caner")
                findNavController().navigate(action)
            }
        }
    }
}