package com.canerture.weektwo

fun main() {
    val persons = mapOf("Ahmet" to 25, "Yağmur" to 25, Pair("Emre", 26))

    println("containsKey -> ${persons.containsKey("Emre")}")
    println("containsKey -> ${persons.containsValue(23)}")

    println(sum(5, 4, "Sonuç 9").second)
    println(sum(5, 6, "Sonuç 10").second)
}

fun sum(a: Int, b: Int, msg: String): Pair<Int, String> {
    return Pair(a + b, msg)
}