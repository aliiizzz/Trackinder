package com.trackinder.domain

import com.trackinder.repository.UserRepository

class UseCaseSaveToken constructor(private val userRepository: UserRepository): UseCaseBase<String, Unit> {
    override fun execute(param: String) = userRepository.saveToken(param)
}