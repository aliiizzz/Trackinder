package com.trackinder.repository.di

import com.trackinder.UserRepository
import com.trackinder.di.ComponentDomain
import com.trackinder.local.di.ComponentLocal
import com.trackinder.local.di.ModuleLocal
import com.trackinder.remote.di.ModuleRemote
import com.trackinder.repository.impl.UserRepositoryImpl
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(modules = [ModuleRepo::class, ModuleLocal::class, ModuleRemote::class], dependencies = [ComponentLocal::class])
interface ComponentRepo: ComponentDomain {

}

@Module()
class ModuleRepo {

    @Provides
    fun provideUserRepository(impl: UserRepositoryImpl): UserRepository = impl
}