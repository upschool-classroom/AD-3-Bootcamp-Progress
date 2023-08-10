package com.canerture.week8.common

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created on 10.08.2023
 * @author Caner Türe
 */

fun ImageView.loadImage(url: String?) {
    Glide.with(this.context).load(url).into(this)
}