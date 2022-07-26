package com.example.musicplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PlaylistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.coolPink)
        setContentView(R.layout.activity_playlist)
    }
}