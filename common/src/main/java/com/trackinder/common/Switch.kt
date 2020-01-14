package com.trackinder.common

class Switch<T>(val value: T, val defaultValue: T) {
    private var isValueUsed = false

    fun get(): T {
        if (isValueUsed.not()) {
            isValueUsed = true
            return value
        }

        return defaultValue
    }
}