package com.trackinder.spotify_login

import android.content.Intent

interface SpotifyLogin {
    fun login()
    fun checkResult(requestCode: Int, resultCode: Int, data: Intent?, resultListener: (token: String?, error: String?) -> Unit)
}