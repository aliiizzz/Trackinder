package com.trackinder.domain

interface UseCaseBase<T, S> {
    suspend fun execute(param: T): S
}