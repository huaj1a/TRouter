package com.huaj1a.trouter.route.ext

import android.graphics.Point
import com.huaj1a.trouter.route.TRouter
import com.huaj1a.trouter.route.TRouterBundle
import com.huaj1a.trouter.window.ModalType

/**
 * Description: trouter with ext
 *
 * @Author: huaj1a
 * @Date: 2025/7/25
 */

fun TRouter.withPosition(position: Point): TRouter {
    checkBuild()
    builder?.position = position
    return this
}

fun TRouter.withBundle(key: String, value: Any): TRouter {
    checkBuild()
    if (builder?.bundle == null)
        builder?.bundle = TRouterBundle()
    builder?.bundle?.put(key, value)
    return this
}

fun TRouter.withModalType(modalType: ModalType): TRouter {
    checkBuild()
    builder?.modalType = modalType
    return this
}

fun TRouter.withDragEnable(enable: Boolean): TRouter {
    checkBuild()
    builder?.dragEnable = enable
    return this
}

fun TRouter.withDoubleClick(enable: Boolean): TRouter {
    checkBuild()
    builder?.doubleDismiss = enable
    return this
}

fun TRouter.withAnimation(animation: Int): TRouter {
    checkBuild()
    builder?.animation = animation
    return this
}

