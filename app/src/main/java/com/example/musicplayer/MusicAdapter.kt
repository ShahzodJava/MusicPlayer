package com.example.musicplayer

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.music_view.view.*

class MusicAdapter(private val context:Context, private  val musicList: ArrayList<Music>):RecyclerView.Adapter<MusicAdapter.MyHolder>() {
    class MyHolder(view: View):RecyclerView.ViewHolder(view) {
        val title = view.songNameMV
        val album  = view.songAlbumMV
        val image = view.imageMV
        val duration = view.songDuration

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicAdapter.MyHolder {
        return MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.music_view, parent, false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.title.text = musicList[position].title
        holder.album.text = musicList[position].album
        holder.duration.text = formatDuration(musicList[position].duration)
        Glide.with(context)
            .load(musicList[position].artUri)
            .apply(RequestOptions().placeholder(R.drawable.ic_music_player_slash_screen).centerCrop())
            .into(holder.image)
        holder.itemView.setOnClickListener{
            val intent = Intent(context, PlayerActivity::class.java)
            intent.putExtra("index", position)
            intent.putExtra("class", "MusicAdapter")
            ContextCompat.startActivity(context, intent, null)
        }
    }

    override fun getItemCount(): Int {
        return musicList.size
    }
}