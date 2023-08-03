package com.canerture.week7.ui.home

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.canerture.week7.R
import com.canerture.week7.common.extension.showDialog
import com.canerture.week7.common.utils.PermissionUtils
import com.canerture.week7.common.utils.PermissionUtils.checkNotificationPermission
import com.canerture.week7.common.viewBinding
import com.canerture.week7.databinding.FragmentHomeBinding
import com.canerture.week7.databinding.SetReminderAlertDialogBinding
import com.canerture.week7.worker.ReminderWorker
import java.util.concurrent.TimeUnit

/**
 * Created on 3.08.2023
 * @author Caner Türe
 */

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    private val requestNotificationPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            binding.btnSetReminder.isEnabled = it
        }

    private lateinit var sharedPref: SharedPreferences

    private var selectedPeriodTime = 0L

    private var selectedPeriodType = "0L"

    private lateinit var request: WorkRequest

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPref = requireContext().getSharedPreferences("AppSettings", Context.MODE_PRIVATE)

        with(sharedPref.edit()) {
            putBoolean("isSignIn", true)
            apply()
        }

        requireContext().checkNotificationPermission(
            onGranted = {
                binding.btnSetReminder.isEnabled = true
            },
            onDenied = {
                binding.btnSetReminder.isEnabled = false
                requestNotificationPermissionLauncher.launch(PermissionUtils.notificationPermission)
            }
        )

        with(binding) {
            btnSetReminder.setOnClickListener {
                showSetReminderDialog()
            }
        }
    }

    private fun showSetReminderDialog() {
        showDialog(SetReminderAlertDialogBinding::inflate) { binding, dialog ->
            with(binding) {
                setPeriodSpinner(actSelectPeriod)

                switchPeriod.setOnCheckedChangeListener { _, isChecked ->
                    selectedPeriodType = if (isChecked) "Repeat" else "One Time"
                }

                btnAdd.setOnClickListener {
                    val reminderText = etReminderText.text.toString()

                    if (reminderText.isNotEmpty()) {
                        setReminder(reminderText, Pair(selectedPeriodType, selectedPeriodTime))
                        dialog.dismiss()
                    }
                }

                btnCancel.setOnClickListener {
                    dialog.dismiss()
                }
            }
        }
    }

    private fun setPeriodSpinner(spinner: AutoCompleteTextView) {
        val periodList = listOf(15L, 30L, 45L)

        val periodAdapter = ArrayAdapter(
            requireContext(),
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            periodList
        )

        spinner.setAdapter(periodAdapter)

        spinner.setOnItemClickListener { _, _, index, _ ->
            selectedPeriodTime = periodList[index]
        }
    }

    private fun setReminder(reminderText: String, period: Pair<String, Long>) {

        val workCondition = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        request = if (period.first == "One Time") {
            OneTimeWorkRequestBuilder<ReminderWorker>()
                .setConstraints(workCondition)
                .setInputData(
                    Data.Builder().putString("reminderText", reminderText).build()
                )
                .setInitialDelay(period.second, TimeUnit.MINUTES)
                .build()
        } else {
            PeriodicWorkRequestBuilder<ReminderWorker>(period.second, TimeUnit.MINUTES)
                .setConstraints(workCondition)
                .setInputData(
                    Data.Builder().putString("reminderText", reminderText).build()
                )
                .build()
        }

        WorkManager.getInstance(requireContext()).enqueue(request)
    }
}