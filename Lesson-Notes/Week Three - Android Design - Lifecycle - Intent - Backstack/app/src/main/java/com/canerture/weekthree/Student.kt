package com.canerture.weekthree

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Student(
    val name: String,
    val age: Int,
    val city: String,
    val country: String,
    val email: String,
    val phone: String
) : Parcelable
