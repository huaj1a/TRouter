package com.huaj1a.trouter.route

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

/**
 * Description:
 *
 * @Author: huaj1a
 * @Date: 2025/7/24
 */
internal class TRouterLifecycleObserver: DefaultLifecycleObserver {

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        TRouter.release()
    }
    
}