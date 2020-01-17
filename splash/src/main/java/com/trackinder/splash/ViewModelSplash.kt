package com.trackinder.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.trackinder.common.*
import com.trackinder.domain.user.UseCaseSaveToken
import com.trackinder.domain.user.UseCaseToken
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ViewModelSplash @Inject constructor(
    private val useCaseToken: UseCaseToken,
    private val appDispatchers: AppDispatchers,
    private val token: String?,
    private val useCaseSaveToken: UseCaseSaveToken
) : ViewModelBase() {

    private lateinit var tokenInfo: LiveData<String>
    private val _navigateMain: MediatorLiveData<Unit> = MediatorLiveData()
    val checkMain: LiveData<Unit> = Transformations.map(_navigateMain) {
        Unit
    }

    init {
        viewModelScope.launch {
            token?.also {
                withContext(appDispatchers.io) {
                    useCaseSaveToken.execute(it)
                }
                navigate(To(FragmentSplashDirections.actionSplashToMain()))
            }
            withContext(appDispatchers.io) {
                tokenInfo = useCaseToken(Unit)
            }

            _navigateMain.addSource(tokenInfo) {
                if (it == null) {
                    navigate(To(FragmentSplashDirections.actionSplashToLogin()))
                } else {
                    navigate(To(FragmentSplashDirections.actionSplashToMain()))
                }
            }
        }
    }
}