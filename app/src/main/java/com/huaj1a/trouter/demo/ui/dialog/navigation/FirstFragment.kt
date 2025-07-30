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
class FirstFragment: BaseComposeFragment() {
    @Composable
    override fun ComposeContent() {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TopBar(
                text = "First",
                backEnable = false
            ) {
                NavHostFragment.findNavController(this@FirstFragment).popBackStack()
            }
            TextButton(
                text = "go second"
            ) {
                NavHostFragment.findNavController(this@FirstFragment).navigate(R.id.first_nav_to_second)
            }
        }
    }
}