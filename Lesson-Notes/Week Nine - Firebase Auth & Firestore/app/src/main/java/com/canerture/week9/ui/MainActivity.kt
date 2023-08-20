package com.canerture.week9.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.canerture.week9.common.viewBinding
import com.canerture.week9.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}