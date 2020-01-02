package com.trackinder.spotify_login

import android.app.Activity
import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationRequest
import com.spotify.sdk.android.authentication.AuthenticationResponse

class SpotifyLoginImpl(val clientId: String, val redirectUrl: String, val activity: Activity): SpotifyLogin {
    override fun login() {
        val request = AuthenticationRequest.Builder(clientId, AuthenticationResponse.Type.TOKEN, redirectUrl).apply {
            setScopes(arrayOf("streaming"))
        }.build()

        AuthenticationClient.openLoginInBrowser(activity, request)
    }
}