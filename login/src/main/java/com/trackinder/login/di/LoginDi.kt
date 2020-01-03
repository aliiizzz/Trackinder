package com.trackinder.login.di

import androidx.lifecycle.ViewModel
import com.trackinder.common.ViewModelBuilder
import com.trackinder.common.ViewModelKey
import com.trackinder.di.AppComponent
import com.trackinder.login.*
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.multibindings.IntoMap


@Module
class LoginModule {
    @Provides
    fun test(): Test = TestImpl()

    @Provides
    @IntoMap
    @ViewModelKey(ViewModelLogin::class)
    fun viewModelLogin(vm: ViewModelLogin): ViewModel = vm
}

@Component(modules = [LoginModule::class, ViewModelBuilder::class], dependencies = [AppComponent::class])
interface LoginComponent {
    @Component.Factory
    interface Factory {
        fun create(appComponent: AppComponent): LoginComponent
    }
    fun inject(fragment: FragmentLogin)
}