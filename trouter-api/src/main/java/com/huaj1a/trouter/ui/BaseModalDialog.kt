package com.huaj1a.trouter.ui

import android.content.Context
import android.graphics.Point
import androidx.activity.ComponentDialog
import com.huaj1a.trouter.route.TRouter
import com.huaj1a.trouter.route.TRouterBundle

/**
 * Description: base modal dialog
 *
 * @Author: huaj1a
 * @Date: 2025/7/24
 */
abstract class BaseModalDialog(
    context: Context, 
    bundleParam: TRouterBundle ?= null
) : ComponentDialog(context) {
    
    var height: Int = 0
    var width: Int = 0
    var position: Point? = null
    var bundle: TRouterBundle? = bundleParam

    override fun dismiss() {
        super.dismiss()
        TRouter.getInstance().removeWindow(javaClass.simpleName)
    }
}