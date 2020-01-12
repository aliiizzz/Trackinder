package com.trackinder.login

import com.trackinder.common.ViewModelBase
import com.trackinder.domain.UseCaseSaveToken
import com.trackinder.spotify_login.SpotifyLogin
import javax.inject.Inject

class ViewModelLogin @Inject constructor(
    private val useCaseSaveToken: UseCaseSaveToken,
    private val spotifyLogin: SpotifyLogin
): ViewModelBase() {

    fun checkToken(token: String?) {
        token?.also {
            useCaseSaveToken.execute(it)
        }
    }

    fun loginClicked() {
        spotifyLogin.login()
    }

}