package com.trackinder.domain

import androidx.lifecycle.LiveData

interface UseCaseSuspendLiveData<T, S> {
    suspend fun invoke(param: T): LiveData<S>
}