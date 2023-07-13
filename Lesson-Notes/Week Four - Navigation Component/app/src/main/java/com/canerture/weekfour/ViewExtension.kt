package com.canerture.weekfour

import android.view.View

fun View.gone() {
    visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun viewsGone(vararg views: View) {
    views.forEach {
        it.gone()
    }
}

fun viewsVisible(vararg views: View) {
    views.forEach {
        it.visible()
    }
}