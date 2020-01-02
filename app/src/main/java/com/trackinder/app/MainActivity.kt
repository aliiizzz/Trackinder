package com.trackinder.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.trackinder.navigation.NavigationHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_main_to_login.setOnClickListener {
            NavigationHelper.toLogin(this)
        }
    }
}
