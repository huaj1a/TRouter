package com.huaj1a.trouter.demo.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Description:
 *
 * @Author: huaj1a
 * @Date: 2025/7/28
 */
@Composable
fun CloseButton(
    onClick: () -> Unit
) {
    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "close",
        modifier = Modifier
            .padding(16.dp)
            .size(24.dp)
            .background(color = Color.White.copy(alpha = 0.5f), shape = CircleShape)
            .clip(CircleShape)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(
                    bounded = true
                ),
                onClick = {
                    onClick()
                }
            )
            .padding(2.dp)
    )
}