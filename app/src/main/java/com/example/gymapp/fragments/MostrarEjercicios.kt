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

class MostrarEjercicios : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val muscleGroup = "brazos"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_1, container, false)
        recyclerView = view.findViewById(R.id.recycler_view)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val exercises = loadExercisesFromJson(requireContext(), muscleGroup)
        recyclerView.adapter = CustomAdapter(exercises)
    }

}

