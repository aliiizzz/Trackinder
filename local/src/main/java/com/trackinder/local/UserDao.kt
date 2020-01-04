package com.trackinder.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.trackinder.local.model.TokenInfo

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveToken(tokenInfo: TokenInfo)
}