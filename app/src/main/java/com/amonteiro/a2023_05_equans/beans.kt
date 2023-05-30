package com.amonteiro.a2023_05_equans

import java.util.Random

fun main() {

    var car = CarBean("toto", "tata")

    val plane = PlaneBean("toto")
    println(plane.id)
    plane.name = "tata"
    println(plane.id)


}

class PlaneBean(name: String){
    var name = name
        set(value) {
            field = value
            id = name.hashCode()
        }


    var id = name.hashCode()
        private set
}

data class CarBean(val marque: String, var model: String) {
    var color : String? = null
}

class StudentBean(val name : String) {
    var note = 0
}

class PrintRandomIntBean(var max : Int){
    val random = Random()

    init {
        println("init")
        println(random.nextInt(max))
        println(random.nextInt(max))
        println(random.nextInt(max))
    }

    constructor() : this(100) {
        println("constructeur secondaire")
        println(random.nextInt(max))
    }
}

