package com.example.actividad15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class MainActivity : AppCompatActivity() {
    val tusDatos: MutableList<TuModeloDeDatos> = mutableListOf()
    val elementos= listOf(
        TuModeloDeDatos("Item1"),
                TuModeloDeDatos("Item2"),
                TuModeloDeDatos("Item3"),
                TuModeloDeDatos("Item4"),
                TuModeloDeDatos("Item5"),
                TuModeloDeDatos("Item6"),
                TuModeloDeDatos("Item7"),
                TuModeloDeDatos("Item8"),
                TuModeloDeDatos("Item9"),
                TuModeloDeDatos("Item10"),
                TuModeloDeDatos("Item11")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tusDatos.addAll(elementos)

        val recyclerView: RecyclerView = findViewById(R.id.reciclerView)
        recyclerView.layoutManager = LinearLayoutManager(this) // Puedes usar otras opciones como GridLayoutManager o StaggeredGridLayoutManager
        val adapter = AdapterRecyclerView(tusDatos) // Crea tu propio adaptador personalizado
        recyclerView.adapter = adapter
    }
}