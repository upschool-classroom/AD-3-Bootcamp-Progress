package com.canerture.week7.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.canerture.week7.common.utils.NotificationUtils

/**
 * Created on 3.08.2023
 * @author Caner Türe
 */

class ReminderWorker(
    private val context: Context,
    private val workerParams: WorkerParameters
): Worker(context, workerParams) {

    override fun doWork(): Result {
        val reminderText = workerParams.inputData.getString("reminderText").orEmpty()
        NotificationUtils.showNotification(context, "Week 7", reminderText)
        return Result.success()
    }
}