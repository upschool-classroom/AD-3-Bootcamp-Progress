package com.canerture.week6.ui

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.RadioButton
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.canerture.week6.R
import com.canerture.week6.common.viewBinding
import com.canerture.week6.data.local.Database
import com.canerture.week6.data.model.User
import com.canerture.week6.databinding.FragmentSignUpBinding
import com.google.android.material.snackbar.Snackbar

/**
 * Created on 27.07.2023
 * @author Caner Türe
 */

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    private val binding by viewBinding(FragmentSignUpBinding::bind)

    private lateinit var db: Database

    private var selectedImage: Bitmap? = null

    private val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        uri?.let {
            selectedImage = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                ImageDecoder.decodeBitmap(ImageDecoder.createSource(requireContext().contentResolver, it))
            } else {
                MediaStore.Images.Media.getBitmap(requireContext().contentResolver, it)
            }
            binding.ivAddPhoto.setImageBitmap(selectedImage)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        db = Database(requireContext())

        with(binding) {
            ivAddPhoto.setOnClickListener {
                pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
            }

            btnSave.setOnClickListener {
                val name = etName.text.toString()
                val email = etEmail.text.toString()
                val type = view.findViewById<RadioButton>(radioGroup.checkedRadioButtonId)?.text.toString()

                if (checkData(selectedImage, name, email, type)) {
                    db.addUser(
                        User(
                            image = selectedImage!!,
                            name = name,
                            email = email,
                            type = type
                        )
                    )
                } else {
                    Snackbar.make(it, "Please fill in the blanks!", 1000).show()
                }
            }

            btnDelete.setOnClickListener {
                db.deleteUser(2)
            }

            println(db.getUsers())
        }
    }

    private fun checkData(image: Bitmap?, name: String, email: String, type: String): Boolean {
        return when {
            image == null -> false
            name.isEmpty() -> false
            email.isEmpty() -> false
            type.isEmpty() -> false
            else -> true
        }
    }
}