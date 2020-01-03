package com.trackinder.login

import com.trackinder.common.ViewModelBase
import javax.inject.Inject

class ViewModelLogin @Inject constructor(): ViewModelBase() {

    fun checkToken(token: String?) {
        token?.also {
            
        }
    }

}