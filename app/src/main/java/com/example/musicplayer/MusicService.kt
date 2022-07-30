package com.example.musicplayer

import android.app.Application
import android.app.Service
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.MediaPlayer
import android.media.session.MediaSession
import android.os.Binder
import android.os.IBinder
import android.support.v4.media.session.MediaSessionCompat
import androidx.core.app.NotificationCompat

class MusicService :Service(){
    private var myBinder = MyBinder()

    var mediaPlayer:MediaPlayer? = null
    private lateinit var mediasSession : MediaSessionCompat

    override fun onBind(p0: Intent?): IBinder? {
        mediasSession = MediaSessionCompat(  baseContext, "My Music")
        return myBinder
    }

    inner class MyBinder:Binder(){
        fun currentService():MusicService{
            return this@MusicService
        }
    }
    fun showNotification() {
        val notification = NotificationCompat.Builder(
            baseContext,
            ApplicationClass.CHANNEL_ID
        )
            .setContentTitle(PlayerActivity.musicListPA[PlayerActivity.songPosition].title)
            .setContentText(PlayerActivity.musicListPA[PlayerActivity.songPosition].artist)
            .setSmallIcon(R.drawable.play_icon)
            .setLargeIcon(
                BitmapFactory.decodeResource(
                    resources,
                    R.drawable.ic_music_player_slash_screen
                )
            )
            .setStyle(androidx.media.app.NotificationCompat.MediaStyle().setMediaSession(mediasSession.sessionToken ))
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .setOnlyAlertOnce(true)
            .addAction(R.drawable.previous_icon,"Previous", null)
            .addAction(R.drawable.play_icon,"Play", null)
            .addAction(R.drawable.next_icon,"Next", null)
            .addAction(R.drawable.exit_icon,"Exit", null)
            .build()
        startForeground(13, notification)
    }

}