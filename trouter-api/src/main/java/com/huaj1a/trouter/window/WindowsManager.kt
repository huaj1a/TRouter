package com.huaj1a.trouter.window

import android.app.Activity
import android.os.Build
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.WindowManager
import com.huaj1a.trouter.R
import com.huaj1a.trouter.route.TRouterBuilder
import com.huaj1a.trouter.ui.BaseDialog
import java.lang.ref.WeakReference
import java.util.concurrent.ConcurrentHashMap

/**
 * Description: window manager
 *
 * @Author: huaj1a
 * @Date: 2025/7/24
 */
internal class WindowsManager {
    
    var screenHeight = 0
    var screenWidth = 0
    var anim: Int = R.style.TRouter_Anim_Fade
    
    private val dialogStack = ConcurrentHashMap<String, BaseDialog>(15)

    /**
     * init
     * 
     * @param activity
     */
    fun init(activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            activity.windowManager.currentWindowMetrics.bounds.apply { 
                screenHeight = height()
                screenWidth = width()
            }
        } else {
            val displayMetrics = DisplayMetrics()
            activity.windowManager.defaultDisplay.getMetrics(displayMetrics)
            displayMetrics.apply { 
                screenHeight = heightPixels
                screenWidth = widthPixels
            }
        }
    }

    /**
     * open window
     * 
     * @param builder
     * @param dialog
     */
    fun openWindow(
        builder: TRouterBuilder,
        dialog: BaseDialog
    ) {
        val window = dialog.window
        if (window == null) {
            return
        }
        window.apply {
            attributes = attributes.apply {
                if (builder.position == null) {
                    gravity = Gravity.CENTER or Gravity.TOP
                    y = (screenHeight - dialog.height) / 2
                } else {
                    gravity = Gravity.START or Gravity.TOP
                    x = builder.position!!.x
                    y = builder.position!!.y
                }
                
                windowAnimations = builder.animation ?: anim
            }
            decorView.setOnTouchListener(
                WindowTouchListener(
                    screenHeight = screenHeight,
                    screenWidth = screenWidth,
                    builder = builder, 
                    dialog = WeakReference(dialog)
                )
            )
            
            // modal setting
            if (builder.modalType == ModalType.MODAL) {
                attributes.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                setDimAmount(0f)
            }

            setBackgroundDrawableResource(android.R.color.transparent)
            setLayout(dialog.width, dialog.height)
        }
        dialogStack.put(builder.path!!, dialog)
        dialog.show()
    }

    /**
     * check dialog open
     * 
     * @param key
     * @return false: not open; true: opening
     */
    fun checkOpen(key: String): Boolean {
        if (!dialogStack.containsKey(key))
            return false
        val dialog = dialogStack.get(key)
        if (dialog == null) {
            dialogStack.remove(key)
            return false
        } 
        if (dialog.isShowing) {
            return true
        }
        dialog.dismiss()
        dialogStack.remove(key)
        return false
    }
    
    fun remove(className: String) {
        dialogStack.entries.removeIf { it.value.javaClass.simpleName.equals(className) }
    }
    
    fun release() {
        dialogStack.forEach { 
            it.value.dismiss()
        }
        dialogStack.clear()
    }

}