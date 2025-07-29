package com.huaj1a.trouter.demo

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.huaj1a.trouter.demo.ui.MainScreen
import com.huaj1a.trouter.demo.ui.theme.TRouterTheme
import com.huaj1a.trouter.route.TRouter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TRouter.openLog()
        TRouter.getInstance().init(this)
        enableEdgeToEdge()
        setContent {
            TRouterTheme {
                MainScreen()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}