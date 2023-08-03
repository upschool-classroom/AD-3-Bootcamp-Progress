package com.canerture.week7.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.telephony.SmsMessage

/**
 * Created on 3.08.2023
 * @author Caner Türe
 */

class OTPReceiver : BroadcastReceiver() {

    companion object {
        private var otpListener: OTPListener? = null
    }

    fun setOTPListener(listener: OTPListener) {
        otpListener = listener
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        val smsMessages: Array<SmsMessage> = Telephony.Sms.Intents.getMessagesFromIntent(intent)

        smsMessages.forEach {
            val msgBody = it.messageBody

            val otp = msgBody.split(":")[1]

            otpListener?.onOTPReceived(otp)
        }
    }
}

interface OTPListener {
    fun onOTPReceived(otp: String)
}