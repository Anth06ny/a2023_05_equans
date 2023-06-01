package com.amonteiro.a2023_05_equans

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import com.amonteiro.a2023_05_equans.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //Créer une instance de l'ihm
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    //Ecran qui va être créé
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Affichage IHM
        setContentView(binding.root)

        //Callback (objet anonyme) clic sur le bouton
        binding.btValidate.setOnClickListener {
            binding.et.setText("Clic sur valider")
        }

        //callback par interface
        binding.btCancel.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        //Identification du bouton cliqué
        if(v === binding.btCancel) {
            binding.et.setText("Clic sur annuler")
        }
    }

}