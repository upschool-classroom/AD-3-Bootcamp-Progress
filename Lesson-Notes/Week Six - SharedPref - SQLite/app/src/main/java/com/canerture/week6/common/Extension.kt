package com.canerture.week6.common

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.ByteArrayOutputStream

/**
 * Created on 27.07.2023
 * @author Caner Türe
 */

fun Bitmap.bitmapToByte(): ByteArray? {
    val stream = ByteArrayOutputStream()
    return try {
        compress(Bitmap.CompressFormat.PNG, 100, stream)
        stream.toByteArray()
    } catch (e: Exception) {
        null
    }
}

fun ByteArray.byteToBitmap(): Bitmap {
    return BitmapFactory.decodeByteArray(this, 0, this.size)
}