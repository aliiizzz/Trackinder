package com.trackinder.remote.di

import com.trackinder.di.ComponentApp
import com.trackinder.remote.api.UserApi
import dagger.Component
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Component(dependencies = [ComponentApp::class], modules = [ModuleRemote::class])
interface ComponentRemote
@Module
class ModuleRemote(val baseUrl: String) {
    @Provides
    fun provideRetrofit() = Retrofit.Builder().baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideUserApi(retrofit: Retrofit): UserApi = retrofit.create(UserApi::class.java)
}