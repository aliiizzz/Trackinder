package com.trackinder.login

import com.trackinder.common.ViewModelBase
import javax.inject.Inject

class ViewModelLogin @Inject constructor(val tst: Test): ViewModelBase() {
    fun test() {

    }

}

interface Test {

}

class TestImpl: Test {

}