package com.canerture.week8.ui.detail

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.canerture.week8.R
import com.canerture.week8.common.gone
import com.canerture.week8.common.loadImage
import com.canerture.week8.common.viewBinding
import com.canerture.week8.common.visible
import com.canerture.week8.databinding.FragmentDetailBinding
import com.canerture.week8.ui.home.MainState
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created on 10.08.2023
 * @author Caner Türe
 */

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val binding by viewBinding(FragmentDetailBinding::bind)

    private val viewModel by viewModels<DetailViewModel>()

    private val args by navArgs<DetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getProductDetail(args.id)

        observeData()
    }

    private fun observeData() = with(binding) {
        viewModel.detailState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is DetailState.Loading -> {
                    progressBar.visible()
                }

                is DetailState.Success -> {
                    progressBar.gone()
                }

                is DetailState.Error -> {
                    ivError.visible()
                    tvError.visible()
                    tvError.text = state.throwable.message.orEmpty()
                    progressBar.gone()
                }
            }
        }
    }
}