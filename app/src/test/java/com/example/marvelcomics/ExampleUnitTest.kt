package com.example.marvelcomics

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.marvelcomics.Data.MarvelApiImpl
import com.example.marvelcomics.Data.MarvelApiRepository
import com.example.marvelcomics.Data.Model.HeroesResponse
import com.example.marvelcomics.Domain.Models.Heroes
import com.example.marvelcomics.Domain.UseCases.GetHeroes
import com.example.marvelcomics.Presenter.Model.HeroesUiModel
import com.example.marvelcomics.Presenter.ViewModel.GetHeroesViewModel
import com.example.marvelcomics.Retrofit.IMarvelApi
import com.example.marvelcomics.Retrofit.key
import com.example.marvelcomics.Utils.OutPut
import com.example.marvelcomics.Utils.parseResponse
import com.example.marvelcomics.di.Modules
import kotlinx.coroutines.*
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import okhttp3.Response
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.mockito.Mock
import org.mockito.MockSettings
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@RunWith(JUnit4::class)
class HeroesUseCaseTest {

    val testCoroutineDispatcher = TestCoroutineDispatcher()

    val restApi = mock<MarvelApiRepository>()
    val getHeroes = GetHeroes(restApi)

    @Before
    fun setup() {
        Dispatchers.setMain(testCoroutineDispatcher)
    }

    @Test
    fun `verify useCase is return not null`() = testCoroutineDispatcher.runBlockingTest {

        val id = 1
        val heroes = Heroes("", "", "", "")

        whenever(restApi.getHeroes(id)).thenReturn(heroes)

        val teste = getHeroes.invoke(id)

        Assert.assertNotNull(teste)
    }
}