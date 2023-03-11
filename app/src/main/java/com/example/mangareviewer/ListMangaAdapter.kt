package com.example.mangareviewer

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListMangaAdapter(private val listManga: ArrayList<Manga>) : RecyclerView.Adapter<ListMangaAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        val tvRate: ImageView = itemView.findViewById(R.id.img_item_rate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_manga, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listManga.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo, rate) = listManga[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.tvRate.setImageResource(rate)

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, MangaDetail::class.java)
            intentDetail.putExtra("key_manga", listManga[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

}