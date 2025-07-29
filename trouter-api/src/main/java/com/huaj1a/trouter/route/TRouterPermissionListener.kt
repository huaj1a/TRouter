package com.huaj1a.trouter.route

/**
 * Description:
 *
 * @Author: huaj1a
 * @Date: 2025/7/28
 */
interface TRouterPermissionListener {

    fun onDenied(deniedList: List<String>)
    
}