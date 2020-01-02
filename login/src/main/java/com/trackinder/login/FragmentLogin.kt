package com.trackinder.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trackinder.common.FragmentBase
import com.trackinder.spotify_login.SpotifyLogin
import com.trackinder.spotify_login.SpotifyLoginImpl
import kotlinx.android.synthetic.main.fragment_login.*

class FragmentLogin: FragmentBase() {

    private lateinit var loginHelper: SpotifyLogin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginHelper = SpotifyLoginImpl(System.getenv("spotifyClientId") ?: "",
            REDIRECT_URL, activity!!)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_login, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_login.setOnClickListener {
            loginHelper.login()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        loginHelper.checkResult(requestCode, resultCode, data) { token, error ->

        }
    }

    companion object {
        val REDIRECT_URL = "https://trackinder.com"
    }
}