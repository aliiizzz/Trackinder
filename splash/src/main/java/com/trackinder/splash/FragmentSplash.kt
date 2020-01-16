package com.trackinder.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.trackinder.common.FragmentBase
import com.trackinder.common.ViewModelBase
import com.trackinder.di.Provider
import com.trackinder.local.di.ModuleLocal
import com.trackinder.splash.di.DaggerComponentSplash
import com.trackinder.splash.di.ModuleSplash
import javax.inject.Inject

class FragmentSplash : FragmentBase()  {
    @Inject lateinit var factory: ViewModelProvider.Factory
    private val viewmodel: ViewModelSplash by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity!!.application as Provider).getComponent().apply {
            DaggerComponentSplash.builder()
                .componentApp(this)
                .moduleSplash(ModuleSplash(getToken()))
                .moduleLocal(ModuleLocal(context!!)).build().inject(this@FragmentSplash)
        }
    }

    private fun getToken(): String? = arguments?.getString("token")
        ?.split("&")?.takeIf { it.size > 1 }?.get(0)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_splash, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel.checkMain.observe(this, Observer {  })
    }
    override fun getViewModel(): ViewModelBase = viewmodel
}