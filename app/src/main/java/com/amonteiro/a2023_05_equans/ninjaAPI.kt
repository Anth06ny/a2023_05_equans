package com.amonteiro.a2023_05_equans

import com.amonteiro.a2023_05_equans.NinjaAPI.loadNinja
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

fun main() {
    println(loadNinja().toList())
}

object NinjaAPI {
    val gson = Gson()

    fun loadNinja() = gson.fromJson(sendGet(), Array<NinjaBean>::class.java)

    fun sendGet(): String {
        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://historical-events-by-api-ninjas.p.rapidapi.com/v1/historicalevents?text=roman%20empire")
            .get()
            .addHeader("X-RapidAPI-Key", "93329c7cf9msha136bd696cd1040p10a1dejsnbc52cdb0746e")
            .addHeader("X-RapidAPI-Host", "historical-events-by-api-ninjas.p.rapidapi.com")
            .build()

        //Execution de la requête
        return client.newCall(request).execute().use { //it:Response
            //use permet de fermer la réponse qu'il y ait ou non une exception
            //Analyse du code retour
            if (!it.isSuccessful) {
                throw Exception("Réponse du serveur incorrect :${it.code}")
            }
            //Résultat de la requête
            it.body.string()
        }
    }
}


data class NinjaBean(
    var day: String,
    var event: String,
    var month: String,
    var year: String
)
