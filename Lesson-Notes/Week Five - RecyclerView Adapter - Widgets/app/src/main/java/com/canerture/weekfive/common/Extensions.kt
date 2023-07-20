package com.canerture.weekfive.common

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import androidx.fragment.app.Fragment
import java.util.Calendar

/**
 * Created on 20.07.2023
 * @author Caner Türe
 */

fun Fragment.showDatePicker(
    calendar: Calendar,
    onDateSelected: (Int, Int, Int) -> Unit
) {
    DatePickerDialog(
        requireContext(),
        { _, year, month, day ->
            onDateSelected(year, month, day)
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    ).show()
}

fun Fragment.showTimePicker(
    calendar: Calendar,
    onTimeSelected: (Int, Int) -> Unit
) {
    TimePickerDialog(
        requireContext(),
        { _, hour, minute ->
            onTimeSelected(hour, minute)
        },
        calendar.get(Calendar.HOUR_OF_DAY),
        calendar.get(Calendar.MINUTE),
        true
    ).show()
}