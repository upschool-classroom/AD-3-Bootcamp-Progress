package com.canerture.kotlinlanguage

fun main() {
    val person = Person()
    person.printSchoolName()
}

class Person : EducationInfo() {
    override val schoolName: String = "İstanbul Üniversitesi"
}

abstract class EducationInfo {

    abstract val schoolName: String

    fun printSchoolName() = println(schoolName)
}