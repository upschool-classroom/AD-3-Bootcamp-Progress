package com.canerture.weektwo

fun main() {
    val number = 50

    try {
        println("50 / $number = ${50 / number}")
    } catch (e: ArithmeticException) {
        println("Matematiksel hata: ${e.message.orEmpty()}")
    } finally {
        println("Finally")
    }
}