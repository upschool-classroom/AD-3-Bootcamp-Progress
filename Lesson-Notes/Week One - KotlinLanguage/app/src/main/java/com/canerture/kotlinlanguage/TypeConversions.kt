package com.canerture.kotlinlanguage

fun main() {

    val stringValue = "10"

    val intValue = stringValue.toInt()

    val age = 26

    val ageString = age.toString()

    //toByte() - toShort() - toInt() - toLong() - toFloat() - toDouble() - toChar() - toString()

    val price = 10

    val priceText = "$price ₺"
    println(priceText)

    val a = 10
    val b = 4

    val result = "$a + $b = ${a + b}"

    println(result)
}