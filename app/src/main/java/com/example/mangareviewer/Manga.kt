package com.example.mangareviewer

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Manga (
    val title: String,
    val review: String,
    val photo: Int,
    val rate: Int,
    val genre: String,
    val background: Int
) : Parcelable