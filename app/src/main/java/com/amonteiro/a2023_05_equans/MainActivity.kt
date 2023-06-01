package com.amonteiro.a2023_05_equans

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.amonteiro.a2023_05_equans.databinding.ActivityMainBinding

const val MENU_WEATHER = 4
class MainActivity : AppCompatActivity() {

    //Créer une instance de l'ihm
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    //Ecran qui va être créé
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        println("Ecran construit")

        //Affichage IHM
        setContentView(binding.root)

        //Callback (objet anonyme) clic sur le bouton
        binding.btValidate.setOnClickListener {
            //version on test tout
            if (binding.rbLike.isChecked) {
                val toto = 5
                //binding.et.setText(binding.rbLike.text)
                binding.et.setText(toto)
            }
            else if (binding.rbDislike.isChecked) {
                binding.et.setText(binding.rbDislike.text)
            }

            //version générique
//            val selectedID = binding.rg.checkedRadioButtonId
//            if (selectedID != -1) {
//                val radioButton = findViewById<RadioButton>(selectedID)
//                binding.et.setText(radioButton.text)
//            }

            binding.iv.setImageResource(R.drawable.baseline_flag_24)
            binding.iv.setColorFilter(getColor(R.color.black))
        }

        binding.btCancel.setOnClickListener {
            binding.et.setText("")
            //Décocher les radiobutton
            binding.rg.clearCheck()

            binding.iv.setImageResource(R.drawable.baseline_delete_forever_24)
        }
    }

    //Callback création du menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add(0,MENU_WEATHER,0,"Météo")

        return super.onCreateOptionsMenu(menu)
    }

    //Callback clic sur le menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == MENU_WEATHER) {
            val intent = Intent(this, WeatherActivity::class.java)
            //lance le nouvel écran
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}