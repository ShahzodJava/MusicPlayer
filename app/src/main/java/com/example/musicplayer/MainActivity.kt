package com.example.musicplayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_MusicPlayer)
        setContentView(R.layout.activity_main)

        shuffle_btn.setOnClickListener(this)
        favourite_btn.setOnClickListener(this)
        playlist_list.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.shuffle_btn->{
                startActivity(Intent(this@MainActivity, PlayerActivity::class.java))
            }
            R.id.favourite_btn->{
                startActivity(Intent(this@MainActivity, FavouriteActivity::class.java))
            }
            R.id.playlist_list->{
                startActivity(Intent(this@MainActivity, PlaylistActivity::class.java))
            }
        }
    }

    private fun myToast(string: String){
        val toast =  Toast.makeText(this,
            "$string clicked",Toast.LENGTH_SHORT)
        toast.show()
    }
}