package com.canerture.week6

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.canerture.week6.common.viewBinding
import com.canerture.week6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        sharedPref = getSharedPreferences("AppSetting", Context.MODE_PRIVATE)

        val isFirstOpen = sharedPref.getBoolean("isFirstOpen", true)

        if (isFirstOpen) Toast.makeText(this, "first", Toast.LENGTH_SHORT).show()
        else Toast.makeText(this, "second", Toast.LENGTH_SHORT).show()

        with(sharedPref.edit()) {
            putBoolean("isFirstOpen", false)
            apply()
        }
    }
}