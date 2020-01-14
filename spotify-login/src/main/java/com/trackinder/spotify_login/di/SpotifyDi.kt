package com.trackinder.spotify_login.di

import android.app.Activity
import android.content.Context
import com.trackinder.spotify_login.SpotifyLogin
import com.trackinder.spotify_login.SpotifyLoginImpl
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(modules = [SpotifyModule::class])
interface SpotifyComponent {
}

@Module
class SpotifyModule(val activity: Activity, val clientId: String) {
    @Provides
    fun provideSpotify(): SpotifyLogin = SpotifyLoginImpl(
        clientId, SpotifySecret.redirectUrl, activity
    )
}

object SpotifySecret {
    const val redirectUrl = "https://trackinder.com"
}