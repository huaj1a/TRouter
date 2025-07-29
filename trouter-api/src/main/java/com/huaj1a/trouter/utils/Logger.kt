package com.huaj1a.trouter.utils

import android.util.Log

/**
 * Description: log
 *
 * @Author: huaj1a
 * @Date: 2025/7/24
 */
internal class Logger {
    val tag: String = "TRouter"
    
    var isShowStackTrace = false

    fun d(message: String) {
        Log.d(tag, message + getExtInfo())
    }
    
    fun i(message: String) {
        Log.i(tag, message + getExtInfo())
    }

    fun w(message: String) {
        Log.w(tag, message + getExtInfo())
    }

    fun e(message: String) {
        Log.e(tag, message + getExtInfo())
    }

    private fun getExtInfo(): String {
        if (!isShowStackTrace)
            return ""
        val stackTraceElement = Thread.currentThread().stackTrace[3]
        val separator = " & "
        val sb = StringBuilder("[")
        val threadName = Thread.currentThread().name
        val fileName = stackTraceElement.fileName
        val className = stackTraceElement.className
        val methodName = stackTraceElement.methodName
        val threadID = Thread.currentThread().getId()
        val lineNumber = stackTraceElement.lineNumber
        sb.append("ThreadId=").append(threadID).append(separator)
        sb.append("ThreadName=").append(threadName).append(separator)
        sb.append("FileName=").append(fileName).append(separator)
        sb.append("ClassName=").append(className).append(separator)
        sb.append("MethodName=").append(methodName).append(separator)
        sb.append("LineNumber=").append(lineNumber)
        sb.append(" ] ")
        return sb.toString()
    }
}