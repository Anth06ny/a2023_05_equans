package com.amonteiro.a2023_05_equans

fun main() {

//    var html = RequestUtils.sendGet("https://www.google.fr")
//    println(html)

    var weather = RequestUtils.loadWeather("Nice")
    println("Il fait ${weather.main.temp}° à ${weather.name} avec un vent de ${weather.wind.speed *3.6} km/s")
}