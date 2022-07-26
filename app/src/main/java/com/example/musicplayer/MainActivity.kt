package com.example.musicplayer

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.app.ActivityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestRuntimePermission()
        setTheme(R.style.coolPinkNav)
        setContentView(R.layout.activity_main)
//      for navigation drawer
        toggle = ActionBarDrawerToggle(this,mainDrawLayout,R.string.open,R.string.close)
        mainDrawLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        shuffle_btn.setOnClickListener(this)
        favourite_btn.setOnClickListener(this)
        playlist_list.setOnClickListener(this)
        navView.setNavigationItemSelectedListener(this)
    }

//    For requesting permission
    private fun requestRuntimePermission(){
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),13)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 13) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show()
            }
            else {
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),13)
            }
        }
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item))
            return true
        return super.onOptionsItemSelected(item)
    }

    private fun myToast(string: String){
        val toast =  Toast.makeText(this,
            "$string clicked",Toast.LENGTH_SHORT)
        toast.show()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.navSettings -> {
                myToast("Setting")
            }
            R.id.navLanguage -> {
                myToast("Language")
            }
            R.id.navAvout -> {
                myToast("About")
            }
            R.id.navLikedSong -> {
                myToast("Liked song")
            }
            R.id.navExit -> {
                myToast("Exit")
            }
        }
        return true
    }
}