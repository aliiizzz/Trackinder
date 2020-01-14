package com.trackinder.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class ViewModelBase : ViewModel() {
    private val _navigation: MutableLiveData<Switch<NavigationDirection?>> = MutableLiveData()
    val navigation: LiveData<Switch<NavigationDirection?>> = _navigation

    fun navigate(direction: NavigationDirection) {
        _navigation.value = Switch(direction, null)
    }
}