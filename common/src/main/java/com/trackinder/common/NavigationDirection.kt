package com.trackinder.common

import androidx.navigation.NavDirections

sealed class NavigationDirection
data class To(val direction: NavDirections): NavigationDirection()
object Back: NavigationDirection()