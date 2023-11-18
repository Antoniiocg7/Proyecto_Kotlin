package com.example.gymapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gymapp.CustomAdapter
import com.example.gymapp.JsonUse.loadExercisesFromJson
import com.example.gymapp.R

class EjerciciosFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var customAdapter: CustomAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ejercicios, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val muscleGroup = arguments?.getString("muscleGroup") ?: "brazos" // Valor por defecto si no se proporciona ninguno

        val exercises = loadExercisesFromJson(requireContext(), muscleGroup)
        customAdapter = CustomAdapter(exercises)
        recyclerView.adapter = customAdapter
    }
}
