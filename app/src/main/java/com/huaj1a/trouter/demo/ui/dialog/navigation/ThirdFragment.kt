package com.huaj1a.trouter.demo.ui.dialog.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.fragment.NavHostFragment
import com.huaj1a.trouter.demo.R
import com.huaj1a.trouter.demo.ui.widget.TextButton
import com.huaj1a.trouter.demo.ui.widget.TopBar

/**
 * Description:
 *
 * @Author: huaj1a
 * @Date: 2025/7/29
 */
class ThirdFragment: BaseComposeFragment() {
    @Composable
    override fun ComposeContent() {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TopBar(
                text = "Third"
            ) {
                NavHostFragment.findNavController(this@ThirdFragment).popBackStack()
            }
            TextButton(
                text = "go first"
            ) {
                NavHostFragment.findNavController(this@ThirdFragment).navigate(R.id.third_nav_to_first)
            }
            TextButton(
                text = "go second"
            ) {
                NavHostFragment.findNavController(this@ThirdFragment).navigate(R.id.third_nav_to_second)
            }
        }
    }
}