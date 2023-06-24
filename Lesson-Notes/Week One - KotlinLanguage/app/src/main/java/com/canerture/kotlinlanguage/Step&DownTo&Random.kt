package com.canerture.kotlinlanguage

fun main() {

    /*for (i in 1..40 step 3) {
        println(i)
    }*/

    /*for (i in 40 downTo 1 step 3) {
        println(i)
    }*/

    val numbers = listOf(1, 2, 3, 4, 5, 6)

    val randomNumber = numbers.random()
    println(randomNumber)
}