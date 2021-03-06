package com.murat.movielist

import com.facebook.stetho.Stetho
import com.murat.movielist.di.component.DaggerApplicationComponent
import com.murat.movielist.di.module.ApplicationModule

class MyApplication : android.app.Application() {

    val component by lazy {
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }


    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this)
    }
}

