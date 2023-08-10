package com.canerture.week8.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.canerture.week8.MainApplication
import com.canerture.week8.R
import com.canerture.week8.common.viewBinding
import com.canerture.week8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        MainApplication.provideRetrofit(this)
    }
}