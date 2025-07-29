package com.huaj1a.trouter.demo.ui.dialog.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment

/**
 * Description:
 *
 * @Author: huaj1a
 * @Date: 2025/7/29
 */
abstract class BaseComposeFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            // 当视图树的生命周期结束时,自动释放组合及其关联的资源
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                ComposeContent()
            }
        }
    }

    @Composable
    abstract fun ComposeContent()
}