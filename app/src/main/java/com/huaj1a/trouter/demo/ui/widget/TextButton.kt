package com.huaj1a.trouter.demo.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Description:
 *
 * @Author: huaj1a
 * @Date: 2025/7/28
 */
@Composable
fun TextButton(
    text: String,
    onClick: () -> Unit
) {
    Text(
        text = text,
        textAlign = TextAlign.Start,
        fontSize = 13.sp,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier.fillMaxWidth()
            .padding(bottom = 8.dp)
            .background(color = Color.Gray.copy(alpha = 0.15f), shape = RoundedCornerShape(50))
            .clip(RoundedCornerShape(50))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(
                    bounded = true
                ),
                onClick = {
                    onClick()
                }
            )
            .padding(vertical = 12.dp, horizontal = 16.dp)
    )
}