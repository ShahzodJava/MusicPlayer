package com.example.musicplayer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class PlayerActivity : AppCompatActivity() {

    companion object {
        lateinit var musicListPA : ArrayList<Music>
        var songPosition : Int = 0
        var mediaPlayer: MediaPlayer? = null
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.coolPink)
        setContentView(R.layout.activity_player)
        songPosition = intent.getIntExtra("index", 0)
        when(intent.getStringExtra("class")){
            "MusicAdapter" -> {
                musicListPA = ArrayList()
                musicListPA.addAll(MainActivity.MusicListMA)
                if (mediaPlayer == null) mediaPlayer = MediaPlayer()
                mediaPlayer!!.reset()
                mediaPlayer!!.setDataSource(musicListPA[songPosition].path)
                mediaPlayer!!.prepare()
                mediaPlayer!!.start()

            }
        }
    }
    private fun setLayout() {
        Glide.with(this)
            .load(musicListPA[songPosition].artUri)
            .apply(RequestOptions().placeholder(R.drawable.ic_music_player_slash_screen).centerCrop())
            .into(holder.image)
    }
}