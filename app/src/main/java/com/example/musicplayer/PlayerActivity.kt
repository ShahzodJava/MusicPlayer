package com.example.musicplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PlayerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_MusicPlayer)
        setContentView(R.layout.activity_player)
    }
}