package com.trackinder.spotify_login

import android.app.Activity
import android.content.Intent
import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationRequest
import com.spotify.sdk.android.authentication.AuthenticationResponse

class SpotifyLoginImpl(val clientId: String, val redirectUrl: String, val activity: Activity): SpotifyLogin {
    override fun login() {
        val request = AuthenticationRequest.Builder(clientId, AuthenticationResponse.Type.TOKEN, redirectUrl).apply {
            setScopes(arrayOf("streaming"))
        }.build()

        AuthenticationClient.openLoginActivity(activity, REQUEST_CODE, request)
    }

    override fun checkResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?,
        resultListener: (token: String?, error: String?) -> Unit
    ) {
        if (requestCode == REQUEST_CODE) {
            AuthenticationClient.getResponse(resultCode, data)?.also {
                when (it.type) {
                    AuthenticationResponse.Type.TOKEN -> resultListener(it.accessToken, null)
                    AuthenticationResponse.Type.ERROR -> resultListener(null, it.error)
                }
            }
        }
    }

    companion object {
        val REQUEST_CODE = 123
    }
}