package com.example.marvelcomics

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.marvelcomics.Domain.Models.Heroes

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.marvelcomics", appContext.packageName)
    }

    @Test
    fun testando(){
        val data  = Data("","", "","", arrayListOf())
        val heroes = Heroes("100","ok","","","",data,"")

        val teste = heroes.teste()

        assertNull(teste)
    }
}