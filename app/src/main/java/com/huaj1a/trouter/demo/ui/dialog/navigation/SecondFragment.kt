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
class SecondFragment: BaseComposeFragment() {
    @Composable
    override fun ComposeContent() {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TopBar(
                text = "Second"
            ) {
                NavHostFragment.findNavController(this@SecondFragment).popBackStack()
            }
            TextButton(
                text = "go third"
            ) {
                NavHostFragment.findNavController(this@SecondFragment).navigate(R.id.second_nav_to_third)
            }
        }
    }

}