package com.canerture.kotlinlanguage

fun main() {

    val smartDevice = SmartDevice("Android TV", "TV", 2)
    smartDevice.showDeviceStatus()
}

class SmartDevice(val name: String, val category: String) {

    var deviceStatus = "Online"

    constructor(name: String, category: String, statusCode: Int) : this(name, category) {
        deviceStatus = when (statusCode) {
            0 -> "Offline"
            1 -> "Online"
            else -> "Unknown"
        }
    }

    fun showDeviceStatus() {
        println(deviceStatus)
    }
}