package com.trackinder.domain.user

import com.trackinder.UserRepository
import com.trackinder.domain.UseCaseBase
import javax.inject.Inject

class UseCaseSaveToken @Inject constructor(private val userRepository: UserRepository):
    UseCaseBase<String, Unit> {
    override suspend fun execute(param: String) = userRepository.saveToken(param)
}