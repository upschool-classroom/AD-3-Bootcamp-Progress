package com.canerture.week7.ui.otp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.canerture.week7.R
import com.canerture.week7.broadcast.OTPListener
import com.canerture.week7.broadcast.OTPReceiver
import com.canerture.week7.common.extension.invisible
import com.canerture.week7.common.extension.visible
import com.canerture.week7.common.utils.PermissionUtils
import com.canerture.week7.common.utils.PermissionUtils.checkSMSPermission
import com.canerture.week7.common.viewBinding
import com.canerture.week7.databinding.FragmentOtpBinding

/**
 * Created on 3.08.2023
 * @author Caner Türe
 */

class OTPFragment : Fragment(R.layout.fragment_otp), OTPListener {

    private val binding by viewBinding(FragmentOtpBinding::bind)

    private val requestSMSPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) {
        if (it) {
            val otpReceiver = OTPReceiver()
            otpReceiver.setOTPListener(this)
        } else {
            findNavController().navigateUp()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireContext().checkSMSPermission(
            onGranted = {
                val otpReceiver = OTPReceiver()
                otpReceiver.setOTPListener(this)
            },
            onDenied = {
                requestSMSPermissionLauncher.launch(PermissionUtils.smsPermission)
            }
        )

        with(binding) {
            btnSendSms.setOnClickListener {
                val phone = etPhone.text.toString()

                if (phone.isNotEmpty()) {

                    tilPhone.invisible()
                    btnSendSms.invisible()

                    etOtpCode.visible()
                    btnVerify.visible()

                    Toast.makeText(requireContext(), "OTP Code Send!", Toast.LENGTH_SHORT).show()
                }
            }

            btnVerify.setOnClickListener {
                val otpCode = etOtpCode.text.toString()

                if (otpCode == "4089") findNavController().navigate(R.id.otpToHome)
            }
        }
    }

    override fun onOTPReceived(otp: String) {
        binding.etOtpCode.setText(otp)
    }
}