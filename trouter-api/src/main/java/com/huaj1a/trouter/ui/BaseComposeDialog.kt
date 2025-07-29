package com.huaj1a.trouter.ui

import android.content.Context
import android.os.Bundle
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.huaj1a.trouter.route.TRouterBundle

/**
 * Description: compose ui
 *
 * @Author: huaj1a
 * @Date: 2025/7/25
 */
abstract class BaseComposeDialog(
    context: Context,
    bundleArgs: TRouterBundle? = null
): BaseDialog(context, bundleArgs) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            ComposeView(context).apply {
                setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
                setContent {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        ComposeContent()
                    }
                }
            }
        )
    }
    
    @Composable
    abstract fun ComposeContent()
}