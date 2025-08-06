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
     * if 0f < height <= 1f, it's the percentage of the screen
     * if 1f < height, it's dp
     */
    val height: Float = 0.5f,

    /**
     * width percent
     * if 0f < width <= 1f, it's the percentage of the screen
     * if 1f < width, it's dp
     */
    val width: Float = 0.5f,

    /**
     * permission array
     */
    val permissions: Array<String> = []
)