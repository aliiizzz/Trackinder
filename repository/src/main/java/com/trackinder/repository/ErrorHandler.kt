package com.trackinder.repository

import com.google.gson.Gson
import com.trackinder.domain.model.ErrorInfo
import com.trackinder.domain.model.ErrorType
import com.trackinder.remote.model.ErrorModel
import retrofit2.HttpException
import retrofit2.Retrofit
import javax.inject.Inject

interface ErrorHandler {
    fun handler(throwable: Throwable): ErrorInfo
}

class ErrorHandlerImpl @Inject constructor(private val gson: Gson):
    ErrorHandler {
    override fun handler(throwable: Throwable): ErrorInfo {
        return (throwable as? HttpException)?.let {
            val code = it.code()
            val body = it.response()?.errorBody()?.string()
            val result = gson.fromJson<ErrorModel>(body, ErrorModel::class.java)
            ErrorInfo(result.message, ErrorType.UNKNOWN, throwable)
        } ?: ErrorInfo(null, ErrorType.UNKNOWN, throwable)
    }
}

