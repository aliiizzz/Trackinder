package com.trackinder.login

import androidx.lifecycle.viewModelScope
import com.trackinder.common.Back
import com.trackinder.common.ViewModelBase
import com.trackinder.domain.user.UseCaseSaveToken
import com.trackinder.spotify_login.SpotifyLogin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ViewModelLogin @Inject constructor(
    private val useCaseSaveToken: UseCaseSaveToken,
    private val spotifyLogin: SpotifyLogin
): ViewModelBase() {

    fun checkToken(token: String?) {
        viewModelScope.launch {
            token?.also {
                withContext(Dispatchers.IO) {
                    useCaseSaveToken.execute(it)
                }
                navigate(Back)
            }
        }

    }

    fun loginClicked() {
        spotifyLogin.login()
    }

}