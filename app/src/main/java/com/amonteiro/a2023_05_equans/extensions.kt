package com.amonteiro.a2023_05_equans

import com.google.gson.Gson

fun main() {
    var carBean: CarBean? = null// CarBean("a", "b")

    println(carBean.toJson())
}

fun Any?.toJson(): String = if (this == null) "{}" else Gson().toJson(this)