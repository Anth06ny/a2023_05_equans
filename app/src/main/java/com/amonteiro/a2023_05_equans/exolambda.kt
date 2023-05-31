package com.amonteiro.a2023_05_equans

fun main() {
    exo1()
}

//exoLambda.kt
fun exo1(){
//    //Déclaration
//    val lower: (String) -> Unit = { s: String ->    println(s.lowercase()) }
//    val lowerV2: (String) -> Unit = { s -> println(s.lowercase()) }
//    val lowerV3: (String) -> Unit = { println(it.lowercase()) }
//    val lowerV4 = { s: String -> println(s.lowercase()) }
//
//    val heure: (Int) -> Int = { it / 60 }
//
//    val max = { a: Int, b: Int -> Math.max(a, b) }
//    val maxV2 = { a: Int, b: Int -> if(a>b) a else b }
//
//    val reverse: (String) -> String = { it.reversed() }
//
//
//    val minToMinHour: (Int) -> Pair<Int, Int> = { Pair(it / 60, it % 60) }
//    val minToMinHourV2 = { it:Int -> Pair(it / 60, it % 60) }
//    //to que l'on verra dans le cours Infix
//    val minToMinHourV3: (Int) -> Pair<Int, Int> = { it / 60 to it % 60 }
//
//    //Utilisation
//    lower("Une phrase avec Des MaJuscules")
//    println("heure : " + heure(62))
//    println("max : " + max(62, 18))
//    println("reverse : " + reverse("Une phrase avec des e"))
//    println("minToMinHour : " + minToMinHour(124))

    data class PersonBean(var name:String, var note:Int) : Comparable<PersonBean> {
        override fun compareTo(other: PersonBean): Int {
            return name.lowercase().compareTo(other.name.lowercase())
        }
    }


    val list = arrayListOf(PersonBean ("toto", 16),
        PersonBean ("Tata", 20),
        PersonBean ("Toto", 8),
        PersonBean ("Toto", 8),
        PersonBean ("Charles", 14))

    println(list.toSortedSet())

}