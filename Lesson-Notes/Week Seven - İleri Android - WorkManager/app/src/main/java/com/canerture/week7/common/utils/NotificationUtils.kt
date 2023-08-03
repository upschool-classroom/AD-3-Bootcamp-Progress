package com.canerture.week7.common.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.os.Build
import androidx.core.app.NotificationCompat
import com.canerture.week7.R

object NotificationUtils {

    fun showNotification(context: Context, title: String, desc: String) {

        val builder: NotificationCompat.Builder

        val notificationManager = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        val channelId = "CHANNEL_ID"
        val channelName = "CHANNEL_NAME"

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
            )

            notificationManager.createNotificationChannel(channel)

            builder = NotificationCompat.Builder(context, channelId)
                .setContentTitle(title)
                .setContentText(desc)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
        } else {
            builder = NotificationCompat.Builder(context)
                .setContentTitle(title)
                .setContentText(desc)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
        }

        notificationManager.notify(1, builder.build())
    }
}