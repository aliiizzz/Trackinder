package com.trackinder.repository.impl

import com.trackinder.local.UserDao
import com.trackinder.local.model.TokenInfo
import com.trackinder.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val userDao: UserDao) :
    UserRepository {
    override suspend fun saveToken(param: String) {
        userDao.saveToken(TokenInfo(1, param))
    }

    override suspend fun getToken(): String = userDao.getToken()
}