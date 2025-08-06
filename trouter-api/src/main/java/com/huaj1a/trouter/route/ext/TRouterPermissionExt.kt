package com.huaj1a.trouter.route.ext

import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.huaj1a.trouter.route.TRouter
import com.huaj1a.trouter.route.TRouterPermissionListener
import com.permissionx.guolindev.PermissionX

/**
 * Description: trouter permission
 *
 * @Author: huaj1a
 * @Date: 2025/7/28
 */
fun TRouter.checkPermission(
    permissions: List<String>,
): Boolean {
    if (permissions.isEmpty()) {
        return true
    }
    if (permissions.all { ContextCompat.checkSelfPermission(context!!.get()!!.baseContext, it) == PackageManager.PERMISSION_GRANTED }) {
        return true
    }
    if (context!!.get()!! !is FragmentActivity) {
        TRouter.logger?.w("context is not FragmentActivity, not check permission")
        return true
    }
    val fragmentActivity = context!!.get()!! as FragmentActivity
    PermissionX.init(fragmentActivity)
        .permissions(permissions)
        .request { allGranted, grantedList, deniedList -> 
            if (allGranted) {
                build(builder!!).navigation()
                return@request
            }
            permissionListener?.onDenied(deniedList)
        }
    return false
}