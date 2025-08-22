package com.huaj1a.trouter.demo.ui.dialog

import android.Manifest
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.huaj1a.trouter.annotation.Route
import com.huaj1a.trouter.demo.ui.theme.pink
import com.huaj1a.trouter.demo.ui.widget.CloseButton
import com.huaj1a.trouter.ui.BaseComposeModalDialog

/**
 * Description:
 *
 * @Author: huaj1a
 * @Date: 2025/7/28
 */
@Route(
    path = AlbumDialogPath,
    height = 0.5f,
    width = 0.75f,
    permissions = [Manifest.permission.READ_MEDIA_IMAGES, Manifest.permission.READ_MEDIA_VIDEO]
)
class AlbumDialog(
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
            Text(
                text = "Album",
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

const val AlbumDialogPath = "/dialog/AlbumDialog"