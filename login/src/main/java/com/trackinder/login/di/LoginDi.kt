package com.trackinder.login.di

import androidx.lifecycle.ViewModel
import com.trackinder.common.ViewModelBuilder
import com.trackinder.common.ViewModelKey
import com.trackinder.di.AppComponent
import com.trackinder.local.di.LocalModule
import com.trackinder.login.*
import com.trackinder.repository.di.RepoModule
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap


@Module()
class LoginModule {
    @Provides
    @IntoMap
    @ViewModelKey(ViewModelLogin::class)
    fun viewModelLogin(vm: ViewModelLogin): ViewModel = vm
}

@Component(modules = [LoginModule::class, ViewModelBuilder::class, RepoModule::class, LocalModule::class],
    dependencies = [AppComponent::class])
interface LoginComponent {

    fun inject(fragment: FragmentLogin)
}