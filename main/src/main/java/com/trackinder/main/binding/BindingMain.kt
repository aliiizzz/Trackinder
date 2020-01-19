package com.trackinder.main.binding

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter

object BindingMain {

    @BindingAdapter("android:visibility")
    @JvmStatic
    fun setVisibility(view: View, visibility: Boolean) {
        view.visibility =  if (visibility) View.VISIBLE else View.GONE
    }

    @BindingAdapter("bind:name")
    @JvmStatic
    fun setName(view: TextView, name: String?) {
        view.setText(name)
    }


}