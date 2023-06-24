package com.canerture.kotlinlanguage

fun main() {

    val age = 11

    /*if (age == 10) {
        println("10 yaşında!")
    } else if (age < 10) {
        println("10 yaşından küçük")
    } else {
        println("10 yaşından büyük")
    }*/

    val number = 9

    /*when (number) {
        1 -> println("Sayı 1")
        2, 3 -> println("Sayı 2 ya da 3")
        in 4 until 7 -> println("Sayı 4 ile 7 arasında")
        !in 4..7 -> println("Sayı 4 ile 7 arasında değil")
        else -> println("Hiçbiri")
    }*/

    when {
        number > 8 -> println("Sayı 8'den büyük")
        number < 8 -> println("Sayı 8'den küçük")
    }
}