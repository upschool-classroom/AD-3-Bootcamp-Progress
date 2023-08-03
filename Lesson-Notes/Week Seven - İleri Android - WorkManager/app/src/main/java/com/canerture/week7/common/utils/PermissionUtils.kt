package com.canerture.week7.common.utils

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.ContextCompat

object PermissionUtils {

    const val smsPermission = Manifest.permission.RECEIVE_SMS
    const val notificationPermission = Manifest.permission.POST_NOTIFICATIONS

    fun Context.checkSMSPermission(onGranted: () -> Unit, onDenied: () -> Unit) {

        if (ContextCompat.checkSelfPermission(this, smsPermission) == PackageManager.PERMISSION_GRANTED) {
            onGranted()
        } else {
            onDenied()
        }
    }

    fun Context.checkNotificationPermission(onGranted: () -> Unit, onDenied: () -> Unit) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, notificationPermission) == PackageManager.PERMISSION_GRANTED) {
                onGranted()
            } else {
                onDenied()
            }
        }
    }
}