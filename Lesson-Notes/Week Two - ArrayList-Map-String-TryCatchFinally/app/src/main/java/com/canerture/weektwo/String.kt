package com.canerture.weektwo

fun main() {
    val name = "Caner"

    //plus
    name.plus(" Türe")
    println("plus -> $name")

    //subSequence
    println("subSequence -> ${name.subSequence(0, 3)}")

    //chunked
    println("chunked -> ${name.chunked(1)}")

    //contains
    println("contains -> ${name.contains("C")}")
    println("contains -> ${name.contains("c")}")

    //startsWith
    println("startsWith -> ${name.startsWith("C")}")
    println("startsWith -> ${name.startsWith("a")}")

    //endsWith
    println("endsWith -> ${name.endsWith("e")}")
    println("endsWith -> ${name.endsWith("r")}")

    //lowercase
    println("lowercase -> ${name.lowercase()}")

    //uppercase
    println("uppercase -> ${name.uppercase()}")

    //replace
    println("replace -> ${name.replace("e", "a")}")

    //reversed
    println("reversed -> ${name.reversed()}")

    //take
    println("take -> ${name.take(3)}")

    //trim
    println("trim -> ${name.plus(" Türe ").trim()}")

    //orEmpty
    name.orEmpty()

    //split
    println("split -> ${name.plus(",Türe").split(",")}")
}