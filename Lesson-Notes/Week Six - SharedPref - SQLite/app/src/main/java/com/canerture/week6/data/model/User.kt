package com.canerture.week6.data.model

import android.graphics.Bitmap

data class User(
    val id: Int = 0,
    val image: Bitmap,
    val name: String,
    val email: String,
    val type: String
)
