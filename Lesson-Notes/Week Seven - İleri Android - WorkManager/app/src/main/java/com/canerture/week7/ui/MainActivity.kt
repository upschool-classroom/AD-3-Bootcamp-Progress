package com.canerture.week7.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.canerture.week7.common.viewBinding
import com.canerture.week7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}