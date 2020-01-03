package com.trackinder.app

import android.app.Application
import com.trackinder.di.AppComponent
import com.trackinder.di.DaggerAppComponent
import com.trackinder.di.Provider

class App: Application(), Provider {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }

    override fun getComponent(): AppComponent = appComponent
    //test
}