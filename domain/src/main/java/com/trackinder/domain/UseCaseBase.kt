package com.trackinder.domain

interface UseCaseBase<T, S> {
    fun execute(param: T): S
}