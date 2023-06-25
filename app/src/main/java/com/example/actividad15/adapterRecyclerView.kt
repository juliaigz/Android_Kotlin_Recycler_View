package com.example.actividad15

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//clase para pasar los valores en una lista del mismo tipo, se puede tener la cantidad de parametros que queramos
data class TuModeloDeDatos(val items: String)

//el daptador donde le entregamos la lista y la funcion de estructura
class AdapterRecyclerView(private val datos: List<TuModeloDeDatos>) : RecyclerView.Adapter<AdapterRecyclerView.TuViewHolder>() {

    //funcion donde se pesca el layout estructural
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return TuViewHolder(view)
    }

    //para cargar la estructura la cantidad de veces necesarias segun ellargo de la lista entregada de datos
    override fun onBindViewHolder(holder: TuViewHolder, position: Int) {
        val item = datos[position]
        holder.bind(item)
    }
    //contador de datos entregados
    override fun getItemCount(): Int {
        return datos.size
    }

    //adaptador de la estructura a los datos entregados
    inner class TuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemTextView: TextView=itemView.findViewById(R.id.nombreTextView)
        fun bind(item: TuModeloDeDatos) {
            itemTextView.text=item.items
        }
    }
}
