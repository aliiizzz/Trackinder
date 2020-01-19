package com.trackinder.main

import androidx.lifecycle.*
import com.trackinder.common.AppDispatchers
import com.trackinder.common.ViewModelBase
import com.trackinder.domain.model.Resource
import com.trackinder.domain.model.ResponseUserProfileDomain
import com.trackinder.domain.model.Status
import com.trackinder.domain.model.toPair
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

    private val _progressVisible: MediatorLiveData<Boolean> = MediatorLiveData()
    val progressVisible: LiveData<Boolean> = _progressVisible

    private val _profileImage: MediatorLiveData<String> = MediatorLiveData()
    val profileImage: LiveData<String> = _profileImage

    private val _profileName: MediatorLiveData<String> = MediatorLiveData()
    val profileName: LiveData<String> = _profileName

    init {
        viewModelScope.launch {
            withContext(appDispatchers.io) {
                profile = useCaseUserProfile(Unit)
            }

            addErrorSource(profile.toPair())
            _progressVisible.addSource(profile) {
                _progressVisible.value = it.status == Status.LOADING
            }

            _profileImage.addSource(profile) {
                if (it.status == Status.SUCCESS) {
                    _profileImage.value = it.data?.images?.firstOrNull()?.url
                }
            }
            _profileName.addSource(profile) {
                if (it.status == Status.SUCCESS) {
                    _profileName.value = it.data?.displayName
                }
            }
            _loadProfile.addSource(profile) {
                if (it.status == Status.SUCCESS) {
                    _loadProfile.value = it.data
                }
            }
        }
    }

    fun importClicked() {
        _progressVisible.value = true
    }
}