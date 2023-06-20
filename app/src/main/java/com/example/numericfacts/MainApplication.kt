package com.example.numericfacts

import android.app.Application
import com.example.numericfacts.di.AppComponent
import com.example.numericfacts.di.ContextModule
import com.example.numericfacts.di.DaggerAppComponent

class MainApplication: Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .contextModule(ContextModule(applicationContext))
            .build()
    }

}