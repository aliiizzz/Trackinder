package com.trackinder.splash

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.trackinder.common.FragmentBase
import com.trackinder.common.ViewModelBase
import javax.inject.Inject

class FragmentSplash : FragmentBase()  {
    @Inject lateinit var factory: ViewModelProvider.Factory
    private val viewmodel: ViewModelSplash by viewModels { factory }

    override fun getViewModel(): ViewModelBase = viewmodel
}