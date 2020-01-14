package com.trackinder.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.trackinder.local.model.TokenInfo

@Database(entities = [TokenInfo::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}