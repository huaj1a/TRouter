package com.huaj1a.trouter.demo.ui.page

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.huaj1a.trouter.demo.R
import com.huaj1a.trouter.demo.ui.dialog.BirdDialogPath
import com.huaj1a.trouter.demo.ui.dialog.navigation.NavigationDialogPath
import com.huaj1a.trouter.demo.ui.widget.TextButton
import com.huaj1a.trouter.route.TRouter
import com.huaj1a.trouter.window.ModalType

/**
 * Description:
 *
 * @Author: huaj1a
 * @Date: 2025/7/28
 */
@Composable
fun IdeaPage() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        item {
            TextButton(
                text = "1.Bird"
            ) {
                TRouter.getInstance()
                    .build(BirdDialogPath)
                    .withModalType(ModalType.MODAL)
                    .withAnimation(R.style.Demo_Bird_Anim)
                    .navigation()
            }

            TextButton(
                text = "2.Navigation Dialog"
            ) {
                TRouter.getInstance()
                    .build(NavigationDialogPath)
                    .withModalType(ModalType.SEMI_MODAL)
                    .navigation()
            }
        }
    }
}