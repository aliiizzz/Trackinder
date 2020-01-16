package com.trackinder.common.di

import com.trackinder.common.AppDispatchers
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers

@Module
class ModuleCommon {
    @Provides
    fun provideDispatchers() = AppDispatchers(Dispatchers.Main, Dispatchers.IO)
}