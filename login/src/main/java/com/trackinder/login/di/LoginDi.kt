package com.trackinder.login.di

import androidx.lifecycle.ViewModel
import com.trackinder.common.ViewModelBuilder
import com.trackinder.common.ViewModelKey
import com.trackinder.di.ComponentApp
import com.trackinder.local.di.ModuleLocal
import com.trackinder.login.*
import com.trackinder.remote.di.ModuleRemote
import com.trackinder.repository.di.ModuleRepo
import com.trackinder.spotify_login.di.SpotifyModule
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

@Component(modules = [LoginModule::class, ViewModelBuilder::class, ModuleRepo::class,
    ModuleLocal::class, SpotifyModule::class, ModuleRemote::class],
    dependencies = [ComponentApp::class])
interface LoginComponent {

    fun inject(fragment: FragmentLogin)
}