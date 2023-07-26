package com.example.ec3_karlos_berrios

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CatImageAdapter(private val catImages: List<String>) :
    RecyclerView.Adapter<CatImageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cat_image, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageUrl = catImages[position]
        Glide.with(holder.itemView.context)
            .load(imageUrl)
            .into(holder.catImageView)
    }

    override fun getItemCount(): Int {
        return catImages.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val catImageView: ImageView = itemView.findViewById(R.id.catImageView)
    }
}
