package com.trackinder

import androidx.lifecycle.LiveData
import com.trackinder.domain.model.Resource
import com.trackinder.domain.model.ResponseUserProfileDomain

interface UserRepository {
    suspend fun saveToken(param: String)
    suspend fun getToken(): LiveData<String>
    suspend fun getProfile(): LiveData<Resource<ResponseUserProfileDomain>>
}