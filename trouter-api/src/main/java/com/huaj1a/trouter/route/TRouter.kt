package com.huaj1a.trouter.route

import android.app.Activity
import android.content.Context
import androidx.activity.ComponentActivity
import com.huaj1a.trouter.TROUTER_PROCESSOR_PACKAGE_NAME
import com.huaj1a.trouter.model.RouteRegistry
import com.huaj1a.trouter.route.ext.checkBuild
import com.huaj1a.trouter.route.ext.checkPermission
import com.huaj1a.trouter.ui.BaseDialog
import com.huaj1a.trouter.utils.ClassUtils
import com.huaj1a.trouter.utils.Logger
import com.huaj1a.trouter.window.WindowsManager
import java.lang.ref.WeakReference

/**
 * Description: TRouter entrance
 *
 * @Author: huaj1a
 * @Date: 2025/7/24
 */
class TRouter private constructor() {
    
    /**
     * must be activity context, create dialog need to this
     */
    internal var context: WeakReference<Activity>? = null
    internal var builder: TRouterBuilder? = null
    internal var permissionListener: TRouterPermissionListener? = null
    
    private var lifecycleObserver: TRouterLifecycleObserver? = null
    private val windowsManager = WindowsManager()
    
    /**
     * If your activity does not have a lifecycle, 
     * please call release() in activity.onDestroy(), 
     * otherwise it will cause memory leaks
     * 
     * @param activity
     */
    fun init(activity: Activity) {
        context = WeakReference(activity)
        windowsManager.init(activity)
        if (activity is ComponentActivity) {
            lifecycleObserver = TRouterLifecycleObserver()
            activity.lifecycle.addObserver(lifecycleObserver!!)
        }
        val classMap = ClassUtils.getFileNameByPackageName(activity, TROUTER_PROCESSOR_PACKAGE_NAME)
        if (classMap.isEmpty()) {
            logger?.w("init: route map is null")
        } else {
            logger?.w("init: route size 【${classMap.size}】")
            classMap.forEach {
                Class.forName(it).newInstance()
            }
        }
        logger?.i("init finish")
    }
    
    fun navigation() {
        checkBuild()
        if (context == null || context?.get() == null) {
            logger?.e("navigation: context is null")
            return
        }
        if (builder?.path == null) {
            logger?.e("navigation: route path is null")
            return
        }
        
        if (windowsManager.checkOpen(builder!!.path!!)) {
            logger?.i("navigation: [${builder!!.path}] already open")
            return
        }
        
        val routeMeta = RouteRegistry.getInstance().get(builder!!.path!!)
        if (routeMeta == null) {
            logger?.e("navigation: [${builder!!.path}] route meta is null")
            return
        } else if (!checkPermission(routeMeta.getPermissions())) {
            logger?.w("navigation: [${builder!!.path}] permission check failed")
            return
        }
        
        val className = routeMeta.className
        val packageName = routeMeta.packageName
        try {
            val _class = Class.forName("${packageName}.${className}")
            val constructor = builder?.bundle?.let {
                _class.getConstructor(Context::class.java, TRouterBundle::class.java)
            } ?: _class.getConstructor(Context::class.java)
            val dialog = builder?.bundle?.let {
                constructor.newInstance(context!!.get(), it)
            } ?: constructor.newInstance(context!!.get())

            if (dialog !is BaseDialog) {
                logger?.e("navigation: dialog is error type")
                return
            }
            dialog.height = (windowsManager.screenHeight * routeMeta.height).toInt()
            dialog.width = (windowsManager.screenWidth * routeMeta.width).toInt()
            dialog.position = builder!!.position
            windowsManager.openWindow(builder!!, dialog)
        } catch (e: Exception) {
            logger?.e(e.stackTraceToString())
        } finally {
            builder = null
            permissionListener = null
        }
    }

    fun globalAnimation(animation: Int) {
        windowsManager.anim = animation
    }
    
    fun removeWindow(className: String) {
        windowsManager.remove(className)
    }
    
    fun release() {
        windowsManager.release()
        lifecycleObserver?.let { observer ->
            (context?.get() as? ComponentActivity)
                ?.lifecycle
                ?.removeObserver(observer)
        }
        context = null
    }
    
    companion object {
        private var instance: TRouter? = null
        internal var logger: Logger? = null
        
        fun getInstance(): TRouter {
            return instance ?: synchronized(this) {
                instance ?: TRouter().also { 
                    instance = it
                }
            }
        }
        
        fun release() {
            instance?.release()
            instance = null
            logger = null
        }
        
        fun openLog() {
            logger = Logger()
        }
        
        fun openLogStackTrace() {
            logger?.isShowStackTrace = true
        }
    }
}