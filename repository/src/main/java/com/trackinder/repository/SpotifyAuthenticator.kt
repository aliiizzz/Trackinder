package com.trackinder.repository

import com.trackinder.local.UserDao
import okhttp3.*
import javax.inject.Inject

class SpotifyAuthenticator @Inject constructor(private val userDao: UserDao) : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        val token = userDao.getToken()
        return response.request().newBuilder().addHeader("Authorization", "Bearer $token").build()
    }
}