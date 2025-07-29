package com.huaj1a.trouter.model

import java.util.concurrent.ConcurrentHashMap

/**
 * Description: global route registry
 *
 * @Author: huaj1a
 * @Date: 2025/7/24
 */
class RouteRegistry private constructor(){
    
    private val routeMap = ConcurrentHashMap<String, RouteMeta>(64)
    
    fun register(key: String, value: RouteMeta) {
        routeMap.put(key, value)
    }
    
    fun get(key: String): RouteMeta? {
        return routeMap[key]
    }
    
    companion object {
        private var instance: RouteRegistry? = null
        
        fun getInstance(): RouteRegistry {
            return instance ?: synchronized(this) {
                instance ?: RouteRegistry().also { 
                    instance = it
                }
            }
        }
    }
}