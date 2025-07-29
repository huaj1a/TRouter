package com.huaj1a.trouter.route

import android.graphics.Point
import com.huaj1a.trouter.window.ModalType

/**
 * Description: route builder
 *
 * @Author: huaj1a
 * @Date: 2025/7/24
 */
data class TRouterBuilder(
    /**
     * route path
     */
    var path: String? = null,

    /**
     * init position
     */
    var position: Point? = null,

    /**
     * data bundle
     */
    var bundle: TRouterBundle? = null,

    /**
     * window modal type
     */
    var modalType: ModalType = ModalType.SEMI_MODAL,

    /**
     * window drag enable
     */
    var dragEnable: Boolean = true,

    /**
     * window double click dismiss
     */
    var doubleDismiss: Boolean = true,

    /**
     * single window anim
     */
    var animation: Int? = null
)
