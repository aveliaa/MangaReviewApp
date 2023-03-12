package com.example.mangareviewer

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MangaDetail : AppCompatActivity(), View.OnClickListener {

    val LINKDEF = "Read it at"
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manga_detail)

        val dataManga = intent.getParcelableExtra<Parcelable>("key_manga") as Manga

        val imgPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvName: TextView = findViewById(R.id.tv_item_name)
        val tvDescription: TextView = findViewById(R.id.tv_item_description)
        val tvRate: ImageView = findViewById(R.id.img_item_rate)
        val tvBackground : ImageView = findViewById(R.id.img_item_cover)
        val tvGenre : TextView = findViewById(R.id.tv_item_genre)
        val tvLink : TextView = findViewById(R.id.tv_item_link)
        val linkTitle : TextView = findViewById(R.id.link_title)

        val btnDialPhone: Button = findViewById(R.id.action_share)
        btnDialPhone.setOnClickListener(this)

        imgPhoto.setImageResource(dataManga.photo)
        tvName.text = dataManga.title
        tvDescription.text = dataManga.review
        tvRate.setImageResource(dataManga.rate)
        tvGenre.text = dataManga.genre
        tvBackground.setImageResource(dataManga.background)
        linkTitle.text = LINKDEF
        tvLink.text = dataManga.link

    }

    override fun onClick(v: View?) {
        val dataManga = intent.getParcelableExtra<Parcelable>("key_manga") as Manga

        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
        shareIntent.putExtra(Intent.EXTRA_TEXT,"So, i just saw ${dataManga.title} got Reviewed on Manga Reviewer App.\nIt is a ${dataManga.genre} manga, you can read it at ${dataManga.link}\nYou should check the review at Manga Reviewer!")
        startActivity(Intent.createChooser(shareIntent,"Share To"))

    }
}


