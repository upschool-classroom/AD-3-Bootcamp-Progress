package com.canerture.week7.common.extension

import android.app.AlertDialog
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * Created on 3.08.2023
 * @author Caner Türe
 */

fun <T : ViewBinding> Fragment.showDialog(
    bindingInflater: (LayoutInflater) -> T,
    bindingAndDialog: (T, AlertDialog) -> Unit
) {
    val builder = AlertDialog.Builder(requireContext())
    val dialogBinding = bindingInflater.invoke(layoutInflater)
    builder.setView(dialogBinding.root)
    val dialog = builder.create()
    bindingAndDialog(dialogBinding, dialog)
    dialog.show()
}