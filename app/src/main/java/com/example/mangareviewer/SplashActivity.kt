package com.example.mangareviewer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            val homeIntent = Intent(this@SplashActivity,HomeActivity::class.java)
            startActivity(homeIntent)
            finish() },3000)
    }
}