package com.canerture.kotlinlanguage

fun main() {

    var name: String? = null

    /*if (name != null) {
        println(name)
    } else {
        println("İsim bulunamadı!")
    }*/



    /*name?.let {
        println(it)
    } ?: run {
        println("İsim bulunamadı!")
    }*/

    //name?.let { println(it) } ?: println("İsim bulunamadı!")

    //println(name ?: "İsim bulunamadı!")

    println(name!!)
}