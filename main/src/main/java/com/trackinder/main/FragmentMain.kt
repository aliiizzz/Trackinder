package com.trackinder.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.trackinder.common.BuildConfig
import com.trackinder.common.FragmentBase
import com.trackinder.common.ViewModelBase
import com.trackinder.common.ViewModelFactory
import com.trackinder.di.Provider
import com.trackinder.local.di.ModuleLocal
import com.trackinder.main.di.DaggerComponentMain
import com.trackinder.remote.di.ModuleRemote
import javax.inject.Inject

class FragmentMain : FragmentBase() {
    @Inject lateinit var factory: ViewModelFactory
    private val viewmodel: ViewModelMain by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.application as? Provider)?.getComponent()?.apply {
            DaggerComponentMain.builder()
                .componentApp(this)
                .moduleLocal(ModuleLocal(context!!))
                .build().inject(this@FragmentMain)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel.loadProfile.observe(this, Observer {  })
    }

    override fun getViewModel(): ViewModelBase = viewmodel
}