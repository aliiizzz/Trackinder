package com.trackinder.app

import android.app.Application
import androidx.fragment.app.FragmentActivity
import com.trackinder.di.ComponentApp
import com.trackinder.di.DaggerComponentApp
import com.trackinder.di.Provider

class App: Application(), Provider {

    private lateinit var appComponent: ComponentApp

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerComponentApp.create()
    }

    override fun getComponent(): ComponentApp = appComponent
}