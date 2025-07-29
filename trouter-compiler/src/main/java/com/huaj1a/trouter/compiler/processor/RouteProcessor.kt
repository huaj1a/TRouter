package com.huaj1a.trouter.compiler.processor

import com.google.auto.service.AutoService
import com.huaj1a.trouter.PERMISSION_SPLIT
import com.huaj1a.trouter.TROUTER_PROCESSOR_PACKAGE_NAME
import com.huaj1a.trouter.annotation.Route
import com.huaj1a.trouter.compiler.KEY_MODULE_NAME
import java.io.IOException
import java.io.Writer
import javax.annotation.processing.Processor
import javax.annotation.processing.RoundEnvironment
import javax.annotation.processing.SupportedOptions
import javax.lang.model.element.TypeElement
import javax.tools.Diagnostic

/**
 * Description:
 *
 * @Author: huaj1a
 * @Date: 2025/7/24
 */
@AutoService(Processor::class)
@SupportedOptions(KEY_MODULE_NAME)
class RouteProcessor: BaseProcessor() {
    override fun process(
        elementMap: Set<TypeElement>,
        roundEnv: RoundEnvironment,
    ): Boolean {
        if (elementMap.isEmpty())
            return false
        
        var writer: Writer? = null
        try {
            val fileName =  moduleName.uppercase() + "$$" + "RouteMap"
            val sourceFile = filer.createSourceFile(fileName)
            writer = sourceFile.openWriter()
            writer.apply {
                write("package $TROUTER_PROCESSOR_PACKAGE_NAME; \n\n")
                write("import com.huaj1a.trouter.model.RouteMeta;\n")
                write("import com.huaj1a.trouter.model.RouteRegistry;\n")
                write("public class $fileName { \n")
                write("    static { \n")
                
                val elements = roundEnv.getElementsAnnotatedWith(Route::class.java)
                elements.forEach { 
                    val packageName = elementUtils.getPackageOf(it).qualifiedName
                    val className = it.simpleName
                    messager.printMessage(Diagnostic.Kind.NOTE, " ---> package: [$packageName], className: [$className]")
                    
                    val annotation = it.getAnnotation(Route::class.java)
                    val path = annotation.path
                    val height = annotation.height
                    val width = annotation.width
                    val permissions = annotation.permissions.joinToString(PERMISSION_SPLIT)
                    
                    write("        RouteRegistry.Companion.getInstance().register(\"$path\", new RouteMeta(\"$path\", \"$packageName\", \"$className\", ${height}f, ${width}f, \"$permissions\")); \n")
                }
                write("    } \n");
                write("}")
            }
        } catch (e: Exception) {
            messager.printMessage(Diagnostic.Kind.ERROR, e.stackTraceToString())
        } finally {
            writer?.apply { 
                try {
                    close()
                } catch (e: IOException) {
                    messager.printMessage(Diagnostic.Kind.ERROR, e.stackTraceToString())
                }
            }
        }
        
        return true
    }
}