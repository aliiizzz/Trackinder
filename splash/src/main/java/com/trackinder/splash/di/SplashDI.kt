package com.trackinder.splash.di

import androidx.lifecycle.ViewModel
import com.trackinder.common.ViewModelBuilder
import com.trackinder.common.ViewModelKey
import com.trackinder.common.di.ModuleCommon
import com.trackinder.di.ComponentApp
import com.trackinder.local.di.ModuleLocal
import com.trackinder.repository.di.ModuleRepo
import com.trackinder.splash.FragmentSplash
import com.trackinder.splash.ViewModelSplash
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Component(modules = [ModuleSplash::class, ViewModelBuilder::class, ModuleRepo::class,
    ModuleLocal::class, ModuleCommon::class], dependencies = [ComponentApp::class])
interface ComponentSplash {
    fun inject(fragment: FragmentSplash)
}

@Module
class ModuleSplash {

    @Provides
    @IntoMap
    @ViewModelKey(ViewModelSplash::class)
    fun provideSplashViewModel(vm: ViewModelSplash): ViewModel = vm
}

