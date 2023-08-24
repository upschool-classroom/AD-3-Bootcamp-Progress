package com.canerture.week8.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.canerture.week8.common.viewBinding
import com.canerture.week8.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}