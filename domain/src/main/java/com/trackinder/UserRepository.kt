package com.trackinder

import androidx.lifecycle.LiveData

interface UserRepository {
    suspend fun saveToken(param: String)
    suspend fun getToken(): LiveData<String>
}