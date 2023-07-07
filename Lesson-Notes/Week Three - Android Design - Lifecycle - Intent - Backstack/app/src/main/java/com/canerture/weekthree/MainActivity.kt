package com.canerture.weekthree

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.canerture.weekthree.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.i("Lifecycle", "onCreate")

        with(binding) {
            btnSave.setOnClickListener {
                val name = etName.text.toString()
                val age = etAge.text.toString()
                val city = etCity.text.toString()
                val country = etCountry.text.toString()
                val email = etMail.text.toString()
                val phone = etPhone.text.toString()

                if (name.isNotEmpty() && age.isNotEmpty() && city.isNotEmpty() && country.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty()) {
                    val student = Student(name, age.toInt(), city, country, email, phone)
                    val intent = Intent(this@MainActivity, ResultActivity::class.java)
                    intent.putExtra("student", student)
                    finish()
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Please fill in the blanks!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("Lifecycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Lifecycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Lifecycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Lifecycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Lifecycle", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Lifecycle", "onRestart")
    }
}