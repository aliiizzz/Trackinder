package com.trackinder.common

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.trackinder.domain.model.ErrorType

abstract class FragmentBase: Fragment() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getViewModel().navigation.observe(this, Observer {
            it.get()?.also {
                when (it) {
                    is To -> findNavController().navigate(it.direction)
                    is Back -> findNavController().popBackStack()
                }
            }
        })

        getViewModel().errorHandle.observe(this, Observer {
            it?.also {
                when(it.type) {
                    ErrorType.UNKNOWN -> findNavController().navigate(R.id.login_navigation, null,
                        NavOptions.Builder().setPopUpTo(R.id.splash_navigation, true).build())
                }
            }
        })
    }

    abstract fun getViewModel(): ViewModelBase
}