package com.example.gymapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.gymapp.R

class imc_fragment : Fragment() {

    private lateinit var peso: EditText
    private lateinit var altura: EditText
    private lateinit var resultado: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_imc_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        peso = view.findViewById(R.id.peso)
        altura = view.findViewById(R.id.altura)
        resultado = view.findViewById(R.id.resultado)
        val btnCalculate: Button = view.findViewById(R.id.calcular)

        btnCalculate.setOnClickListener {
            calculateIMC()
        }
    }

    private fun calculateIMC() {
        val peso = peso.text.toString().toFloatOrNull()
        val altura = altura.text.toString().toFloatOrNull()

        if (peso != null && altura != null && altura != 0f) {
            val imc = peso / ((altura / 100) * (altura / 100))
            resultado.text = "Tu IMC es: %.2f".format(imc)
        } else {
            resultado.text = "Por favor, introduce valores válidos."
        }
    }
}
