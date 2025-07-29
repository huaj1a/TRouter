package com.huaj1a.trouter.model

import com.huaj1a.trouter.PERMISSION_SPLIT

/**
 * Description: route meta
 *
 * @Author: huaj1a
 * @Date: 2025/7/24
 */
data class RouteMeta(
    val path: String,
    val packageName: String,
    val className: String,
    val height: Float,
    val width: Float,
    private val permissions: String
) {
    fun getPermissions(): List<String> {
        return if (permissions.isEmpty()) listOf()
        else permissions.split(PERMISSION_SPLIT)
    }
}