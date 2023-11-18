package com.example.gymapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gymapp.fragments.MostrarEjercicios
import com.example.gymapp.fragments.imc_fragment
import com.example.gymapp.fragments.location
import com.example.gymapp.fragments.seleccionar_musculo
import com.example.gymapp.fragments.share
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.navigation_bar)

        // Define el listener de la BottomNavigationView
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.grafico -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, imc_fragment())
                        .commit()
                    true
                }
                R.id.compartir -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, share())
                        .commit()
                    true
                }
                R.id.ubicacion -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, location())
                        .commit()
                    true
                }
                R.id.meditar -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, seleccionar_musculo())
                        .commit()
                    true
                }
                else -> false
            }
        }

        if (savedInstanceState == null) {
            bottomNavigationView.selectedItemId = R.id.grafico
        }
    }
}
