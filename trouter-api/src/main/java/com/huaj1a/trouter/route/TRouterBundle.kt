package com.huaj1a.trouter.route

/**
 * Description: route bundle
 *
 * @Author: huaj1a
 * @Date: 2025/7/24
 */
class TRouterBundle {
    
    private val map = HashMap<String, Any>()
    
    fun put(key: String, value: Any) {
        map.put(key, value)
    }
    
    fun get(key: String, defaultValue: Any? = null): Any? {
        if (map.contains(key)) 
            return map[key]
        return defaultValue
    }
    
    fun getInt(key: String, defaultValue: Int = 0): Int {
        if (map.contains(key) && map[key] is Int)
            return map[key] as Int
        return defaultValue
    }

    fun getFloat(key: String, defaultValue: Float = 0f): Float {
        if (map.contains(key) && map[key] is Float)
            return map[key] as Float
        return defaultValue
    }

    fun getLong(key: String, defaultValue: Long = 0L): Long {
        if (map.contains(key) && map[key] is Long)
            return map[key] as Long
        return defaultValue
    }

    fun getString(key: String, defaultValue: String = ""): String {
        if (map.contains(key) && map[key] is String)
            return map[key] as String
        return defaultValue
    }

    inline fun <reified T> getList(key: String): List<T>? {
        val value = get(key)
        if (value is List<*>) {
            // 检查元素类型是否符合 T
            if (value.all { it is T }) {
                @Suppress("UNCHECKED_CAST")
                return value as List<T>
            }
        }
        return null
    }
    
    inline fun <reified T> getObject(key: String): T? {
        val value = get(key)
        if (value is T) {
            return value
        }
        return null
    }

}