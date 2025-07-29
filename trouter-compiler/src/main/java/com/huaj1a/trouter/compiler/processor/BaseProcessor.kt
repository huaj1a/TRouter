package com.huaj1a.trouter.compiler.processor

import com.huaj1a.trouter.annotation.Route
import com.huaj1a.trouter.compiler.KEY_MODULE_NAME
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.Filer
import javax.annotation.processing.Messager
import javax.annotation.processing.ProcessingEnvironment
import javax.lang.model.util.Elements
import javax.tools.Diagnostic

/**
 * Description:
 *
 * @Author: huaj1a
 * @Date: 2025/7/24
 */
abstract class BaseProcessor: AbstractProcessor() {
    
    lateinit var elementUtils: Elements
    lateinit var messager: Messager
    lateinit var filer: Filer
    lateinit var moduleName: String

    override fun init(processingEnv: ProcessingEnvironment) {
        super.init(processingEnv)
        processingEnv.apply {
            this@BaseProcessor.elementUtils = elementUtils
            this@BaseProcessor.messager = messager
            this@BaseProcessor.filer = filer
            
            messager.printMessage(Diagnostic.Kind.NOTE, " ---> Hello TRouter")
            if (!options.isNullOrEmpty() && options.contains(KEY_MODULE_NAME)) {
                moduleName = options[KEY_MODULE_NAME]!!
                messager.printMessage(Diagnostic.Kind.NOTE, " ---> module: $moduleName")
            }
        }
    }

    override fun getSupportedAnnotationTypes(): Set<String?>? {
        return HashSet<String>().apply { 
            add(Route::class.java.canonicalName)
        }
    }

    override fun getSupportedOptions(): Set<String?>? {
        return HashSet<String>().apply { 
            add(KEY_MODULE_NAME)
        }
    }
    
}