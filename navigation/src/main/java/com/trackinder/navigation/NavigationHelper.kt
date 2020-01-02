package com.trackinder.navigation

import android.app.Activity
import android.content.Intent
import android.net.Uri

object NavigationHelper {
    fun toLogin(activity: Activity) {
        activity.startActivity(
            Intent(Intent.ACTION_VIEW, Uri.parse("https://trackinder.com")).apply {
                setPackage("com.trackinder.app")
            }
        )
    }
}