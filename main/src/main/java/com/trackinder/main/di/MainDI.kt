package com.trackinder.main.di

import androidx.lifecycle.ViewModel
import com.trackinder.common.ViewModelBuilder
import com.trackinder.common.ViewModelKey
import com.trackinder.common.di.ModuleCommon
import com.trackinder.di.ComponentApp
import com.trackinder.local.di.ModuleLocal
import com.trackinder.main.FragmentMain
import com.trackinder.main.ViewModelMain
import com.trackinder.remote.di.ModuleRemote
import com.trackinder.repository.di.ModuleRepo
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Component(dependencies = [ComponentApp::class], modules = [
    ModuleMain::class, ViewModelBuilder::class, ModuleRepo::class, ModuleLocal::class, ModuleRemote::class, ModuleCommon::class
])
interface ComponentMain {
    fun inject(fragment: FragmentMain)
}

@Module
class ModuleMain {

    @Provides
    @IntoMap
    @ViewModelKey(ViewModelMain::class)
    fun provideViewModel(vm: ViewModelMain): ViewModel = vm
}
