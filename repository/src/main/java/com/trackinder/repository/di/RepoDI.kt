package com.trackinder.repository.di

import com.google.gson.Gson
import com.trackinder.UserRepository
import com.trackinder.di.ComponentDomain
import com.trackinder.local.UserDao
import com.trackinder.local.di.ComponentLocal
import com.trackinder.local.di.ModuleLocal
import com.trackinder.remote.di.ModuleRemote
import com.trackinder.repository.ErrorHandler
import com.trackinder.repository.ErrorHandlerImpl
import com.trackinder.repository.SpotifyAuthenticator
import com.trackinder.repository.impl.UserRepositoryImpl
import dagger.Component
import dagger.Module
import dagger.Provides
import okhttp3.Authenticator

@Component(modules = [ModuleRepo::class, ModuleLocal::class, ModuleRemote::class], dependencies = [ComponentLocal::class])
interface ComponentRepo: ComponentDomain {

}

@Module()
class ModuleRepo {

    @Provides
    fun provideUserRepository(impl: UserRepositoryImpl): UserRepository = impl

    @Provides
    fun provideAuthenticator(userDao: UserDao): Authenticator = SpotifyAuthenticator(userDao)

    @Provides
    fun provideErrorHandler(gson: Gson): ErrorHandler = ErrorHandlerImpl(gson)
}