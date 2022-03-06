package com.example.marvelcomics

import com.example.marvelcomics.data.MarvelApiRepository
import com.example.marvelcomics.domain.models.Heroes
import com.example.marvelcomics.domain.useCases.GetHeroes
import kotlinx.coroutines.*
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.kotlin.mock
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