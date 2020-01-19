package com.trackinder.remote.model

import com.google.gson.annotations.SerializedName

data class ErrorModel(
    @field:SerializedName("message")
    val message: String? = null
)