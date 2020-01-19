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
import com.trackinder.main.databinding.FragmentMainBinding
import com.trackinder.main.di.DaggerComponentMain
import com.trackinder.remote.di.ModuleRemote
import javax.inject.Inject

class FragmentMain : FragmentBase() {
    @Inject lateinit var factory: ViewModelFactory
    private val vm: ViewModelMain by viewModels { factory }

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
    ): View? = FragmentMainBinding.inflate(inflater).apply {
        this.viewmodel = vm
        lifecycleOwner = this@FragmentMain
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.loadProfile.observe(this, Observer {  })
    }

    override fun getViewModel(): ViewModelBase = vm
}