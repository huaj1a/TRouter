package com.huaj1a.trouter.demo.ui.dialog.navigation

import android.content.Context
import com.huaj1a.trouter.annotation.Route
import com.huaj1a.trouter.ui.BaseDialog

/**
 * Description:
 *
 * @Author: huaj1a
 * @Date: 2025/7/29
 */
@Route(
    path = NavigationDialogPath,
    height = 0.5f,
    width = 0.75f
)
class NavigationDialog(
    context: Context
): BaseDialog(context) {
    
}

const val NavigationDialogPath = "/dialog/NavigationDialog"