package com.trackinder.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.trackinder.local.model.TokenInfo

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveToken(tokenInfo: TokenInfo)

    @Query("select token from token where id = 1")
    fun getToken(): String
}