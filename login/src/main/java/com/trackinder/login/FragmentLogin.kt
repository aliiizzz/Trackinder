package com.trackinder.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.trackinder.common.FragmentBase
import com.trackinder.common.ViewModelBase
import com.trackinder.di.Provider
import com.trackinder.local.di.ModuleLocal
import com.trackinder.login.di.DaggerLoginComponent
import com.trackinder.remote.di.ModuleRemote
import com.trackinder.spotify_login.di.SpotifyModule
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

class FragmentLogin: FragmentBase() {

    @Inject lateinit var factory: ViewModelProvider.Factory
    private val viewmodel: ViewModelLogin by viewModels { factory }
    private var token: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity!!.application as Provider).getComponent().apply {
            DaggerLoginComponent.builder()
                .componentApp(this)
                .moduleLocal(ModuleLocal(context!!))
                .spotifyModule(SpotifyModule(activity!!, BuildConfig.spotifyClientId))
                .build().inject(this@FragmentLogin)
        }
        token = arguments?.getString("token")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_login, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel.checkToken(token)
        button_login.setOnClickListener {
            viewmodel.loginClicked()
        }
    }

    override fun getViewModel(): ViewModelBase = viewmodel
}