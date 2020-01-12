package com.trackinder.local.di

import android.content.Context
import androidx.room.Room
import com.trackinder.di.AppComponent
import com.trackinder.local.AppDatabase
import com.trackinder.local.UserDao
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(modules = [LocalModule::class])
interface LocalComponent {

}

@Module
class LocalModule(val context: Context) {

    @Provides
    fun provideDb(): AppDatabase = Room.databaseBuilder(
        context, AppDatabase::class.java, "trackinder"
    ).build()

    @Provides
    fun provideUserDao(appDatabase: AppDatabase): UserDao = appDatabase.userDao()
}