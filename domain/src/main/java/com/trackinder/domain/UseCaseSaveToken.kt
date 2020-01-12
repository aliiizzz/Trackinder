package com.trackinder.domain

import com.trackinder.UserRepository
import javax.inject.Inject

class UseCaseSaveToken @Inject constructor(private val userRepository: UserRepository): UseCaseBase<String, Unit> {
    override fun execute(param: String) = userRepository.saveToken(param)
}