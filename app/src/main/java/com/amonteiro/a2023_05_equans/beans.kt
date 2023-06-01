package com.amonteiro.a2023_05_equans

import java.util.Random

fun main() {

    var car = CarBean("toto", "tata")
    var car2 = CarBean("toto", "tata")

//    val plane = PlaneBean("toto")
//    println(plane.id)
//    plane.name = "tata"
//    println(plane.id)

    val random = RandomName()
    random.add("D")
    repeat(10) {
        print(random.next() + " ")
    }

}

/* -------------------------------- */
// API Météo
/* -------------------------------- */
data class WeatherBean(var name: String, var main: TempBean, var wind: WindBean, var weather :List<DescriptionBean>?)
data class TempBean(var temp: Double, var temp_min:Double, var temp_max:Double)
data class WindBean(var speed: Double)
data class DescriptionBean(var description: String, var icon:String)

/* -------------------------------- */
// Exo
/* -------------------------------- */

class RandomName {
    private val list = arrayListOf("A", "B", "C")
    private var oldValue = ""

    fun add(name: String?) = if (!name.isNullOrBlank() && name !in list) list.add(name) else false

    fun next() = list.random()

    fun next2() = Pair(nextDiff(), nextDiff())


    fun nextDiff(): String = list.filter { it != oldValue }.random().apply {
        oldValue = this
    }


}

class PlaneBean(name: String) {
    var name = name
        set(value) {
            field = value
            id = name.hashCode()
        }


    var id = name.hashCode()
        private set
}


data class CarBean(val marque: String, var model: String) {
    var color: String? = null
}

class StudentBean(val name: String) {
    var note = 0
}

class PrintRandomIntBean(var max: Int) {
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

