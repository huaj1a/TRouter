package com.huaj1a.trouter.route.ext

import com.huaj1a.trouter.route.TRouter
import com.huaj1a.trouter.route.TRouterBuilder

/**
 * Description: trouter build ext
 *
 * @Author: huaj1a
 * @Date: 2025/7/25
 */
fun TRouter.build(path: String): TRouter {
    builder = TRouterBuilder(
        path = path
    )
    return this
}

fun TRouter.build(builder: TRouterBuilder): TRouter {
    this.builder = builder
    return this
}

fun TRouter.checkBuild() {
    if (builder == null)
        throw RuntimeException("TRouter error: must build first")
}