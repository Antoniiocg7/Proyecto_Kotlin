package com.example.gymapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gymapp.CustomAdapter
import com.example.gymapp.JsonUse.loadExercisesFromJson
import com.example.gymapp.R


class seleccionar_musculo : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var customAdapter: CustomAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_seleccionar_musculo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        customAdapter = CustomAdapter(emptyList())
        recyclerView.adapter = customAdapter

        view.findViewById<Button>(R.id.boton_brazos).setOnClickListener {
            navigateToExercisesFragment("brazos")
        }
        view.findViewById<Button>(R.id.boton_espalda).setOnClickListener {
            navigateToExercisesFragment("espalda")
        }
        view.findViewById<Button>(R.id.boton_pecho).setOnClickListener {
            navigateToExercisesFragment("pecho")
        }
        view.findViewById<Button>(R.id.boton_pierna).setOnClickListener {
            navigateToExercisesFragment("piernas")
        }

    }

    private fun navigateToExercisesFragment(muscleGroup: String) {
        val fragment = EjerciciosFragment().apply {
            arguments = Bundle().apply {
                putString("muscleGroup", muscleGroup)
            }
        }

        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
