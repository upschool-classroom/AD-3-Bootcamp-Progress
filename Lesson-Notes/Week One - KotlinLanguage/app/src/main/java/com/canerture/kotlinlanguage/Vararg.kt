package com.canerture.kotlinlanguage

fun main() {

    println(sum(10, 20))
}

fun sum(vararg values: Int): Int {

    var result = 0

    values.forEach {
        result += it
    }

    return result
}