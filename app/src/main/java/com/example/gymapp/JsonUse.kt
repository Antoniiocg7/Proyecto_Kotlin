package com.example.gymapp

import android.content.Context
import org.json.JSONObject

object JsonUse {
    fun loadExercisesFromJson(context: Context, muscleGroup: String): List<Ejercicio> {
        val inputStream = context.assets.open("ejercicios.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val jsonStr = String(buffer, Charsets.UTF_8)

        val jsonObj = JSONObject(jsonStr)
        val rutinaEjerciciosObj = jsonObj.getJSONObject("rutinaEjercicios")
        val muscleGroupArray = rutinaEjerciciosObj.getJSONArray(muscleGroup)
        val exercisesList = ArrayList<Ejercicio>()

        for (i in 0 until muscleGroupArray.length()) {
            val jsonObject = muscleGroupArray.getJSONObject(i)
            val ejercicio = Ejercicio(
                name = jsonObject.getString("nombre"),
                detail = jsonObject.getString("descripcion"),
            )
            exercisesList.add(ejercicio)
        }

        return exercisesList
    }
}

