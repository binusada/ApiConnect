package com.example.randomuser

import android.app.Application
import com.example.randomuser.di.AppContainer

class RandomUserApplication : Application() {
    lateinit var appContainer: AppContainer

    override fun onCreate() {
        super.onCreate()
        appContainer = AppContainer()
    }
}
