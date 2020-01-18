package com.trackinder.remote.api

import com.trackinder.remote.model.ResponseUserProfile
import retrofit2.http.GET

interface UserApi {
    @GET("me")
    suspend fun userProfile(): ResponseUserProfile
}