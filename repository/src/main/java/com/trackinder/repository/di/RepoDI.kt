package com.trackinder.repository.di

import com.trackinder.di.AppComponent
import com.trackinder.UserRepository
import com.trackinder.di.DomainComponent
import com.trackinder.local.di.LocalComponent
import com.trackinder.local.di.LocalModule
import com.trackinder.repository.impl.UserRepositoryImpl
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(modules = [RepoModule::class, LocalModule::class], dependencies = [LocalComponent::class])
interface RepoComponent: DomainComponent {

}

@Module()
class RepoModule {

    @Provides
    fun provideUserRepository(impl: UserRepositoryImpl): UserRepository = impl
}