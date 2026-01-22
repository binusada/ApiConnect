package com.apiconnect

import android.app.Application
import com.apiconnect.di.AppContainer

class RandomUserApplication : Application() {
    lateinit var appContainer: AppContainer

    override fun onCreate() {
        super.onCreate()
        appContainer = AppContainer()
    }
}
