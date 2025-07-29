package com.huaj1a.trouter.annotation

/**
 * Description: route annotation
 *
 * @Author: huaj1a
 * @Date: 2025/7/24
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.BINARY)
annotation class Route(

    /**
     * route path
     */
    val path: String,

    /**
     * height percent
     */
    val height: Float = 0.5f,

    /**
     * width percent
     */
    val width: Float = 0.5f,

    /**
     * permission array
     */
    val permissions: Array<String> = []
)