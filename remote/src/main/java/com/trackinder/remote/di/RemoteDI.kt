package com.trackinder.remote.di

import com.trackinder.di.ComponentApp
import com.trackinder.remote.BuildConfig
import com.trackinder.remote.api.UserApi
import dagger.Component
import dagger.Module
import dagger.Provides
import okhttp3.Authenticator
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Component(dependencies = [ComponentApp::class], modules = [ModuleRemote::class])
interface ComponentRemote
@Module
class ModuleRemote() {
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder().baseUrl(BuildConfig.baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Provides
    fun provideClient(authenticator: Authenticator) = OkHttpClient.Builder().authenticator(authenticator).build()

    @Provides
    fun provideUserApi(retrofit: Retrofit): UserApi = retrofit.create(UserApi::class.java)
}