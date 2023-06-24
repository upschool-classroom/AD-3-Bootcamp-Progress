package com.canerture.weektwo

data class Person(val name: String, val age: Int)

data class Name(val name: String)

fun main() {
    val persons = arrayListOf(
        Person("Ahmet", 25),
        Person("Yağmur", 25),
        Person("Emre", 26),
        Person("Yağmur", 23)
    )

    //size
    println("size -> ${persons.size}")

    //add
    persons.add(Person("Caner", 26))
    println("add -> $persons")

    //addAll
    persons.addAll(
        listOf(
            Person("Zeynep", 32),
            Person("Elif", 23)
        )
    )
    println("addAll -> ${persons}")

    //remove
    persons.remove(Person("Caner", 26))
    println("remove -> $persons")

    //removeAt
    persons.removeAt(2)
    println("removeAt -> $persons")

    //forEach
    persons.forEach {
        println("foreach -> $it")
    }

    //forEachIndexed
    persons.forEachIndexed { index, person ->
        println("forEachIndexed -> $index - ${person.name}")
    }

    //contains
    println("contains -> ${persons.contains(Person("Caner", 26))}")

    //indexOf
    println("indexOf -> ${persons.indexOf(Person("Yağmur", 25))}")

    //isEmpty
    println("isEmpty -> ${persons.isEmpty()}")
    println("isNotEmpty -> ${persons.isNotEmpty()}")
    println("isNullOrEmpty -> ${persons.isNullOrEmpty()}")
    println("!isNullOrEmpty -> ${!persons.isNullOrEmpty()}")

    //filter
    println("filter -> ${persons.filter { it.age == 25 }}")

    //find
    println("find -> ${persons.find { it.age == 25 }}")
    println("find -> ${persons.findLast { it.age == 25 }}")

    //first
    println("first -> ${persons.first()}")

    //last
    println("last -> ${persons.last()}")

    //getOrNull
    println("getOrNull -> ${persons.getOrNull(3)}")
    println("getOrNull -> ${persons.getOrNull(14)}")

    //groupBy
    println("groupBy -> ${persons.groupBy { it.age }.values}")

    //none
    println("none -> ${persons.none { it.name == "Yağmur" }}")

    //toSet
    persons.add(Person("Elif", 23))
    println("toSet -> $persons")
    println("toSet -> ${persons.toSet()}")

    //map
    println("map -> ${persons.map { it.age * 2 }}")
    println("map -> ${persons.map { it.name }}")
    println("map -> ${persons.map { Name(it.name) }}")
    println("map -> ${persons.map { Person(it.name, it.age * 2) }}")

    //random
    println("random -> ${persons.random()}")

    //reverse - reversed
    println("reverse -> $persons")
    println("reverse -> ${persons.reverse()}")
    println("reversed -> ${persons.reversed()}")

    //shuffle - shuffled
    println("shuffle -> $persons")
    println("shuffle -> ${persons.shuffle()}")
    println("shuffled -> ${persons.shuffled()}")

    //sortBy - sortedBy
    println("sortBy -> $persons")
    println("sortBy -> ${persons.sortBy { it.age }}")
    println("sortedBy -> ${persons.sortedBy { it.age }}")

    //sortByDescending - sortedByDescending
    println("sortByDescending -> $persons")
    println("sortByDescending -> ${persons.sortByDescending { it.age }}")
    println("sortedByDescending -> ${persons.sortedByDescending { it.age }}")

    //sumOf
    println("sumOf -> ${persons.sumOf { it.age }}")

    //maxOf - maxBy
    println("maxOf -> ${persons.maxOf { it.age }}")
    println("maxBy -> ${persons.maxBy { it.age }}")

    //minOf - minBy
    println("minOf -> ${persons.minOf { it.age }}")
    println("minBy -> ${persons.minBy { it.age }}")

    //orEmpty
    persons.orEmpty()

    //clear
    persons.clear()
    println("clear -> $persons")
}