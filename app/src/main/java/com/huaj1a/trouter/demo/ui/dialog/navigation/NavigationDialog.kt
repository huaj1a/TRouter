package com.huaj1a.trouter.demo.ui.dialog.navigation

import android.content.Context
import android.os.Bundle
import com.huaj1a.trouter.annotation.Route
import com.huaj1a.trouter.demo.databinding.NavigationDialogBinding

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
): BaseNavigationDialog(context) {
    
    private lateinit var binding: NavigationDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NavigationDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addNavController(binding.navDialog)
    }
    
}

const val NavigationDialogPath = "/dialog/NavigationDialog"