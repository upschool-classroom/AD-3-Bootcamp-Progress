package com.canerture.week7.ui.signin

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.canerture.week7.R
import com.canerture.week7.common.viewBinding
import com.canerture.week7.databinding.FragmentSignInBinding

/**
 * Created on 3.08.2023
 * @author Caner Türe
 */

class SignInFragment : Fragment(R.layout.fragment_sign_in) {

    private val binding by viewBinding(FragmentSignInBinding::bind)

    private lateinit var sharedPref: SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPref = requireContext().getSharedPreferences("AppSettings", Context.MODE_PRIVATE)

        val isSignIn = sharedPref.getBoolean("isSignIn", false)

        if (isSignIn) {
            findNavController().navigate(R.id.signInToHome)
        }

        with(binding) {

            btnSignIn.setOnClickListener {
                val email = etEmail.text.toString()
                val password = etPassword.text.toString()

                if (email.isNotEmpty() && password.isNotEmpty()) {
                    findNavController().navigate(R.id.signInToOtp)
                }
            }
        }
    }
}