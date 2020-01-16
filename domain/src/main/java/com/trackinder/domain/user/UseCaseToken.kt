package com.trackinder.domain.user

import androidx.lifecycle.LiveData
import com.trackinder.UserRepository
import com.trackinder.domain.UseCaseSuspendLiveData
import javax.inject.Inject

class UseCaseToken @Inject constructor(private val userRepository: UserRepository) : UseCaseSuspendLiveData<Unit, String> {
    override suspend operator fun invoke(param: Unit): LiveData<String> = userRepository.getToken()
}