package com.trackinder.common

import androidx.navigation.NavDirections
import androidx.navigation.NavOptions

sealed class NavigationDirection
data class To(val direction: NavDirections, val options: NavOptions? = null): NavigationDirection()
object Back: NavigationDirection()