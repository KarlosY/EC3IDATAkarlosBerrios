package com.example.ec3_karlos_berrios

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PerroAdapter(private var perros: List<Perro>) : RecyclerView.Adapter<PerroAdapter.PerroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_perro, parent, false)
        return PerroViewHolder(view)
    }

    override fun onBindViewHolder(holder: PerroViewHolder, position: Int) {
        val perro = perros[position]
        holder.bind(perro)
    }

    override fun getItemCount(): Int = perros.size

    fun setData(newPerros: List<Perro>) {
        perros = newPerros
        notifyDataSetChanged()
    }

    inner class PerroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val bredForTextView: TextView = itemView.findViewById(R.id.bredForTextView)
        private val breedGroupTextView: TextView = itemView.findViewById(R.id.breedGroupTextView)
        private val lifeSpanTextView: TextView = itemView.findViewById(R.id.lifeSpanTextView)
        private val temperamentTextView: TextView = itemView.findViewById(R.id.temperamentTextView)
        private val originTextView: TextView = itemView.findViewById(R.id.originTextView)

        fun bind(perro: Perro) {
            nameTextView.text = perro.name
            bredForTextView.text = perro.bred_for
            breedGroupTextView.text = perro.breed_group
            lifeSpanTextView.text = perro.life_span
            temperamentTextView.text = perro.temperament
            originTextView.text = perro.origin
        }
    }
}
