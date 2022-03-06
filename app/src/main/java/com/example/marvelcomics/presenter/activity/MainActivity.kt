package com.example.marvelcomics.presenter.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelcomics.presenter.adapter.HeroesAdapter
import com.example.marvelcomics.presenter.model.HeroesUiModel
import com.example.marvelcomics.presenter.viewModel.GetHeroesViewModel
import com.example.marvelcomics.R
import com.example.marvelcomics.utils.OutPut
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val viewModel: GetHeroesViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getHeroesImpl(1)

        viewModel.getHeroesLiveData.observe(this, {
            response(it)
        })

    }

    fun response(response: OutPut<HeroesUiModel>) {
        when (response) {
            is OutPut.Failure -> {
                Toast.makeText(this, "Error ${response.error}", Toast.LENGTH_LONG).show()
            }
            is OutPut.Success -> {
                val adapter = HeroesAdapter(this,viewModel)
                adapter.add(response.value)

                findViewById<RecyclerView>(R.id.rcHeroes).apply {
                    this.adapter = adapter
                    this.layoutManager =
                        LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                }

                Log.i("Heroes", "List Herores ${response.value}")
            }
        }
    }
}