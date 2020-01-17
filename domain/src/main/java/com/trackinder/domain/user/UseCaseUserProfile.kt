package com.trackinder.domain.user

import androidx.lifecycle.LiveData
import com.trackinder.UserRepository
import com.trackinder.domain.UseCaseSuspendLiveData
import com.trackinder.domain.model.Resource
import com.trackinder.domain.model.ResponseUserProfileDomain
import javax.inject.Inject

class UseCaseUserProfile @Inject constructor(private val userRepository: UserRepository) : UseCaseSuspendLiveData<Unit, Resource<ResponseUserProfileDomain>> {
    override suspend operator fun invoke(param: Unit): LiveData<Resource<ResponseUserProfileDomain>> = userRepository.getProfile()
}