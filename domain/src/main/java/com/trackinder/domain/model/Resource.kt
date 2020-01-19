package com.trackinder.domain.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations

data class Resource<T>(val status: Status, val data: T?, val error: ErrorInfo?)

enum class Status{
    LOADING, SUCCESS, ERROR
}

fun <T> Resource<T>.toPair() = Pair(this.status == Status.ERROR, this.error)

fun <T> LiveData<Resource<T>>.toPair() = Transformations.map(this) { it.toPair() }