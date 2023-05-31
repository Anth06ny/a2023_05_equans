package com.amonteiro.a2023_05_equans

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import com.amonteiro.a2023_05_equans.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Créer l'IHM
    val binding by lazy {  ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Affichage
        setContentView(binding.root)

        binding.btValidate.setOnClickListener {
            println("coucou")
        }

    }

}