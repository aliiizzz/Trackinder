package com.trackinder.repository.impl

import com.trackinder.local.UserDao
import com.trackinder.local.model.TokenInfo
import com.trackinder.repository.UserRepository

class UserRepositoryImpl(private val userDao: UserDao) : UserRepository {
    override fun saveToken(param: String) {
        userDao.saveToken(TokenInfo(1, param))
    }
}