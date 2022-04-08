package com.lharo.exam

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ApplicationsAdapter(context: Context, feedEntries: ArrayList<MovieModel>): RecyclerView.Adapter<ApplicationsAdapter.ViewHolder>() {

    private var localContext: Context? = null
    private var localFeedEntries: ArrayList<MovieModel>? = null


    init {
        localContext = context
        localFeedEntries = feedEntries
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApplicationsAdapter.ViewHolder{
        val layoutInflater: LayoutInflater = LayoutInflater.from(localContext)
        val view: View = layoutInflater.inflate(R.layout.viewcard, parent, false)
        return ViewHolder(view)
    }


    //Asignar valores a las filas cuando son reintroducidasa a la pantalla basadas en la posición que tienen en la vista
    override fun onBindViewHolder(holder: ApplicationsAdapter.ViewHolder, position: Int) {
        val currentFeedEntry: MovieModel = localFeedEntries!![position]
        holder.Title.text = currentFeedEntry.title
        holder.Director.text = currentFeedEntry.director
        holder.Year.text = currentFeedEntry.year
        holder.Language.text = currentFeedEntry.language
    }

    override fun getItemCount(): Int {
        return localFeedEntries?.size ?: 0
    }

    class ViewHolder(v: View): RecyclerView.ViewHolder(v) {

        val Title: TextView = v.findViewById(R.id.MovieName)
        val Director: TextView = v.findViewById(R.id.director)
        val Year: TextView = v.findViewById(R.id.year)
        val Language: TextView = v.findViewById(R.id.language)


    }

}