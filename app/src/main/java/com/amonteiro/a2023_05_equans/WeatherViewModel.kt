package com.amonteiro.a2023_05_equans

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.Exception
import kotlin.concurrent.thread

class WeatherViewModel : ViewModel() {

    //Donnée
    var data = MutableLiveData<WeatherBean?>(null)
    var errorMessage = MutableLiveData("")
    var runInProgress = MutableLiveData(false)

    //Chargement des données
    fun loadData(city: String) {

        //reset de donnée
        data.postValue(null)
        errorMessage.postValue("")
        runInProgress.postValue(true)
        thread {
            try {
                //Déclanche l'action associé sur l'UIThread
                data.postValue(RequestUtils.loadWeather(city))
            }
            catch (e: Exception) {
                //Ca ne marche pas
                e.printStackTrace()
                errorMessage.postValue("Une erreur est survenue : ${e.message}")
            }

            runInProgress.postValue(false)
        }
    }

}