package com.trackinder.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "token")
data class TokenInfo(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "token") val token: String
)