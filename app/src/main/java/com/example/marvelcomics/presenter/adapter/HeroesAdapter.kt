package com.example.marvelcomics.presenter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelcomics.presenter.model.HeroesUiModel
import com.example.marvelcomics.presenter.viewModel.GetHeroesViewModel
import com.example.marvelcomics.R

class HeroesAdapter(val context : Context, val viemModel : GetHeroesViewModel) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val listHeroes : ArrayList<HeroesUiModel> = arrayListOf()
    var i : Int = 1

    fun add( heroes : HeroesUiModel){
        listHeroes.add(heroes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       return HeroesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.heroes_marvel_item,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if(position == itemCount){
            i++
            viemModel.getHeroesImpl(i)
        }
        val heroes = holder as HeroesViewHolder
        val list = listHeroes[position]
         heroes.bindHeores(list, context)
    }

    override fun getItemCount(): Int {
        return listHeroes.size
    }
}