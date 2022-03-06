package com.example.marvelcomics.Presenter.Adapter

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvelcomics.Presenter.Model.HeroesUiModel
import com.example.marvelcomics.R

class HeroesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindHeores(heroesUiModel: HeroesUiModel, context: Context) {
        itemView.findViewById<TextView>(R.id.txtNameHeores).text = heroesUiModel.name
        Glide.with(context)
            .load(heroesUiModel.url)
            .into(itemView.findViewById(R.id.imgHeroes))
    }
}
