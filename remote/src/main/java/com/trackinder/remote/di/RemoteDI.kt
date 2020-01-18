package com.trackinder.remote.di

import com.trackinder.di.ComponentApp
import com.trackinder.remote.BuildConfig
import com.trackinder.remote.api.UserApi
import dagger.Component
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Component(dependencies = [ComponentApp::class], modules = [ModuleRemote::class])
interface ComponentRemote
@Module
class ModuleRemote() {
    @Provides
    fun provideRetrofit() = Retrofit.Builder().baseUrl(BuildConfig.baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideUserApi(retrofit: Retrofit): UserApi = retrofit.create(UserApi::class.java)
}