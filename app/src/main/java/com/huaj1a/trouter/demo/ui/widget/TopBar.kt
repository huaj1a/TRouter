package com.huaj1a.trouter.demo.ui.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

/**
 * Description:
 *
 * @Author: huaj1a
 * @Date: 2025/7/29
 */
@Composable
fun TopBar(
    text: String = "",
    backEnable: Boolean = true,
    onBack: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxWidth()
            .padding(12.dp)
    ) {
        if (backEnable) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterStart)
                    .size(20.dp)
                    .clickable { onBack() }
            )
        }

        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}