package com.canerture.kotlinlanguage

fun main() {

    val numbers = listOf(1, 2, 3, 4, 5, 6)

    //println(numbers.size)
    //println(numbers[2])

    val names = mutableListOf("Caner", "Zeynep", "Begüm", "Burak")

    println(names.size)
    names.add("Büşra")
    println(names)
    names.add(0, "Ali")
    println(names)
    println(names[0])

    //println(names.shuffled())

    /*for (i in 0 until names.size) {
        println(names[i])
    }*/

    /*for (name in names) {
        println(name)
    }*/

    names.forEach { name ->
        println(name)
    }
}