package com.example.gymapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private var ejercicios: List<Ejercicio>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombre: TextView = view.findViewById(R.id.nombre)
        val detalles: TextView = view.findViewById(R.id.detalles)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dataitem, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ejercicio = ejercicios[position]
        holder.nombre.text = ejercicio.name
        holder.detalles.text = ejercicio.detail
    }

    override fun getItemCount() = ejercicios.size

    fun updateData(newExercises: List<Ejercicio>) {
        ejercicios = newExercises
    }

}

