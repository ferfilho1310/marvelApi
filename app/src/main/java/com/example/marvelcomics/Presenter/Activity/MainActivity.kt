package com.example.marvelcomics.Presenter.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.marvelcomics.Presenter.ViewModel.GetHeroesViewModel
import com.example.marvelcomics.R
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val viewModel : GetHeroesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getHeroesImpl()

        viewModel.getHeroesLiveData.observe(this, {
            Log.i("Heroes","List Herores ${it.data}")
        })

    }
}