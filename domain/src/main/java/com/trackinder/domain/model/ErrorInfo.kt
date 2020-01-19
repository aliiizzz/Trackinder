package com.trackinder.domain.model

data class ErrorInfo(val message: String?, val type: ErrorType, val throwable: Throwable?)

enum class ErrorType {
    UNKNOWN
}