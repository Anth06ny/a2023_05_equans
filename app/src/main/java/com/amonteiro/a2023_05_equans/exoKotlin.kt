package com.amonteiro.a2023_05_equans

import kotlin.concurrent.thread

fun main() {










//    Créer une variable v1 de type String et y mettre la chaine "toto"
    var v1 = "toto"
    println(v1.uppercase())
//    Afficher dans la console sa version en majuscule (uppercase)
//    Essayer d'y mettre la valeur null. (Erreur de compilation)

//    Créer une variable v2 de type String nullable et y mettre la chaine "toto"
    var v2: String? = "toto"

//    Afficher dans la console sa version en majuscule. Obligé de mettre le safe check
    println(v2?.uppercase())

//    Créer une variable v3 de type String nullable et y mettre la valeur null
    var v3: String? = null
//    Afficher dans la console sa version en majuscule
    println(v3?.uppercase())

//            Pour les plus rapides :
//    Si on met v3 + v3 dans une variable, quelle sera son typage ?
    var v4 = v3 + v3

//    Écrire le if qui fait que si v3 est nulle, vide ou fait que d'espaces affiche "Toto" dans la console
    if (v3.isNullOrBlank()) {
        println("toto")
    }

    boulangerie(1,2,3)
    boulangerie(1, 2)
    boulangerie(nbSand = 4)
    boulangerie(2, nbSand = 4)


}


fun boulangerie(nbCroissant:Int = 0, nbBaguette:Int = 0, nbSand : Int = 0) =
    nbCroissant * PRICE_CROISSANT + nbBaguette * PRICE_BAGUETTE + nbSand * PRICE_SAND

fun min(a: Int, b: Int, c: Int) = if (a < b && a < c) a else if (b < a && b < c) b else c

fun pair(c:Int) = c%2 ==0
fun myPrint(text:String) = print("#$text#")


