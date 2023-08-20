package com.canerture.week9.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Note(
    val documentId: String? = null,
    val title: String? = null,
    val description: String? = null
) : Parcelable
