package com.example.mangareviewer

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvManga: RecyclerView
    private val list = ArrayList<Manga>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        rvManga = findViewById(R.id.rv_recycle_manga)
        rvManga.setHasFixedSize(true)

        list.addAll(getListManga())
        showRecyclerList()
    }

    @SuppressLint("Recycle")
    private fun getListManga(): ArrayList<Manga> {
        val dataName = resources.getStringArray(R.array.data_title)
        val dataDescription = resources.getStringArray(R.array.data_review)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataRate = resources.obtainTypedArray(R.array.data_rate)
        val dataGenre = resources.getStringArray(R.array.data_genre)
        val dataBg = resources.obtainTypedArray(R.array.data_bg)

        val listManga = ArrayList<Manga>()
        for (i in dataName.indices) {
            val manga = Manga(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1),dataRate.getResourceId(i, -1),dataGenre[i],dataBg.getResourceId(i,-1))
            listManga.add(manga)
        }
        return listManga
    }

    private fun showRecyclerList() {
        rvManga.layoutManager = LinearLayoutManager(this)
        val listMangaAdapter = ListMangaAdapter(list)
        rvManga.adapter = listMangaAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.to_about_me -> {
                val moveIntent = Intent(this@MainActivity, AboutMeActivity::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}


