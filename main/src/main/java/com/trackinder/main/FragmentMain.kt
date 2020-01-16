package com.trackinder.main

import androidx.fragment.app.viewModels
import com.trackinder.common.FragmentBase
import com.trackinder.common.ViewModelBase
import com.trackinder.common.ViewModelFactory
import javax.inject.Inject

class FragmentMain : FragmentBase() {
    @Inject lateinit var factory: ViewModelFactory
    private val viewmodel: ViewModelMain by viewModels { factory }

    override fun getViewModel(): ViewModelBase = viewmodel
}