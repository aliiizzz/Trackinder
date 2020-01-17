package com.trackinder.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.trackinder.common.FragmentBase
import com.trackinder.common.ViewModelBase
import com.trackinder.common.ViewModelFactory
import javax.inject.Inject

class FragmentMain : FragmentBase() {
    @Inject lateinit var factory: ViewModelFactory
    private val viewmodel: ViewModelMain by viewModels { factory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel.loadProfile.observe(this, Observer {  })
    }

    override fun getViewModel(): ViewModelBase = viewmodel
}