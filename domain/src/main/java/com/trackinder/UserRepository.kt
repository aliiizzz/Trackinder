package com.trackinder

interface UserRepository {
    suspend fun saveToken(param: String)
    suspend fun getToken(): String
}