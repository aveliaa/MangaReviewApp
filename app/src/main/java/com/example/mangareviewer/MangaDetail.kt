package com.example.mangareviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.ImageView
import android.widget.TextView

class MangaDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manga_detail)

        val dataManga = intent.getParcelableExtra<Parcelable>("key_manga") as Manga

        val imgPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvName: TextView = findViewById(R.id.tv_item_name)
        val tvDescription: TextView = findViewById(R.id.tv_item_description)
        val tvRate: ImageView = findViewById(R.id.img_item_rate)

        imgPhoto.setImageResource(dataManga.photo)
        tvName.text = dataManga.title
        tvDescription.text = dataManga.review
        tvRate.setImageResource(dataManga.rate)

    }
}


