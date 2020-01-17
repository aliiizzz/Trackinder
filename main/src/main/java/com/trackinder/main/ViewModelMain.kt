package com.trackinder.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.viewModelScope
import com.trackinder.common.AppDispatchers
import com.trackinder.common.ViewModelBase
import com.trackinder.domain.model.Resource
import com.trackinder.domain.model.ResponseUserProfileDomain
import com.trackinder.domain.model.Status
import com.trackinder.domain.user.UseCaseUserProfile
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ViewModelMain @Inject constructor(
    private val useCaseUserProfile: UseCaseUserProfile,
    private val appDispatchers: AppDispatchers
) : ViewModelBase() {

    private lateinit var profile: LiveData<Resource<ResponseUserProfileDomain>>

    private val _loadProfile: MediatorLiveData<ResponseUserProfileDomain> = MediatorLiveData()
    val loadProfile: LiveData<ResponseUserProfileDomain> = _loadProfile

    init {
        viewModelScope.launch {
            withContext(appDispatchers.io) {
                profile = useCaseUserProfile(Unit)
            }

            _loadProfile.addSource(profile) {
                if (it.status == Status.SUCCESS) {
                    _loadProfile.value = it.data
                }
            }
        }
    }
}