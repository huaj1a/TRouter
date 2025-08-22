package com.huaj1a.trouter.demo.ui.dialog

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.huaj1a.trouter.annotation.Route
import com.huaj1a.trouter.demo.ui.theme.pink
import com.huaj1a.trouter.demo.ui.widget.CloseButton
import com.huaj1a.trouter.ui.BaseComposeModalDialog

/**
 * Description:
 *
 * @Author: huaj1a
 * @Date: 2025/7/25
 */
@Route(
    path = BasicComposeDialogPath,
    height = 0.5f,
    width = 0.75f
)
class BasicComposeDialog(
    context: Context
): BaseComposeModalDialog(context) {
    @Composable
    override fun ComposeContent() {
        Box(
            modifier = Modifier.fillMaxSize()
                .background(color = pink, shape = RoundedCornerShape(14.dp))
        ) {
            CloseButton { 
                dismiss()
            }
        }
    }
}

const val BasicComposeDialogPath = "/dialog/BasicComposeDialog"