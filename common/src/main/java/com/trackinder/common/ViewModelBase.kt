package com.trackinder.common

import androidx.lifecycle.*
import com.trackinder.domain.model.ErrorInfo

open class ViewModelBase : ViewModel() {
    private val _navigation: MutableLiveData<Switch<NavigationDirection?>> = MutableLiveData()
    val navigation: LiveData<Switch<NavigationDirection?>> = _navigation
    private val _errorHandle: MediatorLiveData<ErrorInfo> = MediatorLiveData()
    val errorHandle: LiveData<ErrorInfo> = _errorHandle

    fun navigate(direction: NavigationDirection) {
        _navigation.value = Switch(direction, null)
    }

    fun addErrorSource(source: LiveData<Pair<Boolean, ErrorInfo?>>) {
        _errorHandle.addSource(source) {
            if (it.first) {
                _errorHandle.value = it.second
            }
        }
    }
}