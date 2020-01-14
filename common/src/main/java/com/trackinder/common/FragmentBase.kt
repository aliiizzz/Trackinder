package com.trackinder.common

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

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
    }

    abstract fun getViewModel(): ViewModelBase
}