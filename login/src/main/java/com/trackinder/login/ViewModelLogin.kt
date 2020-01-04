package com.trackinder.login

import com.trackinder.common.ViewModelBase
import com.trackinder.domain.UseCaseSaveToken
import javax.inject.Inject

class ViewModelLogin @Inject constructor(private val useCaseSaveToken: UseCaseSaveToken): ViewModelBase() {

    fun checkToken(token: String?) {
        token?.also {
            useCaseSaveToken.execute(it)
        }
    }

}