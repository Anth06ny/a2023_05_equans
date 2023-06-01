package com.amonteiro.a2023_05_equans

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.amonteiro.a2023_05_equans.databinding.ActivityWeatherBinding
import com.squareup.picasso.Picasso

class WeatherActivity : AppCompatActivity() {

    //IHM
    val binding by lazy { ActivityWeatherBinding.inflate(layoutInflater) }

    //Données
    val model by lazy { ViewModelProvider(this).get(WeatherViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        observable()

        binding.btLoad.setOnClickListener {
            //Gestion des données
            model.loadData(binding.etCityName.text.toString())
        }
    }

    fun observable() {

        model.data.observe(this) {
            //IHM WeatherBean
            binding.tv.text = it?.name ?: "-"
            binding.tvWind.text = it?.wind?.speed?.toString() ?: "-"
            binding.tvTemp.text = "${it?.main?.temp ?: "-"}°"
            binding.tvMinMax.text = "(${it?.main?.temp_min ?: "-"}°/${it?.main?.temp_max ?: "-"}°)"

            binding.tvDesc.text = "${it?.weather?.firstOrNull()?.description ?: "-"}"

            Picasso.get()
                .load("https://openweathermap.org/img/wn/${it?.weather?.firstOrNull()?.icon}@4x.png")
                .into(binding.ivTemp)
        }

        model.errorMessage.observe(this) {
            //Partie erreur
            binding.tvError.isVisible = it.isNotBlank()
            binding.tvError.text = it
        }

        model.runInProgress.observe(this) {
            //Partie erreur
            binding.progressBar.isVisible = it
        }

    }
}

