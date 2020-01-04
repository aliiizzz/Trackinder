package com.trackinder.domain

import androidx.lifecycle.LiveData

interface UseCaseBaseLiveData<T, S> {
    fun execute(param: T): LiveData<S>
}