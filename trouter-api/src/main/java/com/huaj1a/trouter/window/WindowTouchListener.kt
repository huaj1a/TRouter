package com.huaj1a.trouter.window

import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import com.huaj1a.trouter.route.TRouter
import com.huaj1a.trouter.route.TRouterBuilder
import com.huaj1a.trouter.ui.BaseDialog
import java.lang.ref.WeakReference

/**
 * Description: window touch event
 *
 * @Author: huaj1a
 * @Date: 2025/7/24
 */
class WindowTouchListener(
    private val screenHeight: Int,
    private val screenWidth: Int,
    private val builder: TRouterBuilder,
    private val dialog: WeakReference<BaseDialog>
) : View.OnTouchListener {
    
    private var startX = 0
    private var startY = 0
    private var endX = dialog.get()?.window?.attributes?.x ?: 0
    private var endY = dialog.get()?.window?.attributes?.y ?: 0
    
    private var lastClickTime: Long = 0
    
    @SuppressLint("ClickableViewAccessibility")
    override fun onTouch(view: View, event: MotionEvent): Boolean {
        dialog.get()?.apply {
            if (builder.modalType == ModalType.SEMI_MODAL)
                window?.attributes?.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
            when(event.action) {
                MotionEvent.ACTION_DOWN -> {
                    startX = event.rawX.toInt()
                    startY = event.rawY.toInt()

                    val clickTime = System.currentTimeMillis()
                    if (clickTime - lastClickTime < 300 && builder.doubleDismiss) {
                        dismiss()
                    } else {
                        lastClickTime = clickTime
                        window?.attributes = window?.attributes?.apply {
                            x = endX
                            y = endY
                        }
                        show()
                    }
                }
                MotionEvent.ACTION_MOVE -> {
                    if (!builder.dragEnable)
                        return false
                    val nowX = event.rawX.toInt()
                    val nowY = event.rawY.toInt()
                    val moveX = nowX - startX
                    val moveY = nowY - startY
                    startX = nowX
                    startY = nowY
                    // limit window position, avoid infinite stacking distance
                    endX = (endX + moveX).coerceIn(-(screenWidth - width) / 2, screenWidth - width)
                    endY = (endY + moveY).coerceIn(0, screenHeight - height)
                    window?.attributes = window?.attributes?.apply { 
                        x = endX
                        y = endY
                    }
                    show()
                }
            }
        } ?: {
            TRouter.logger?.w("WindowTouchListener: dialog is null")
        }
        return false
    }
    
}