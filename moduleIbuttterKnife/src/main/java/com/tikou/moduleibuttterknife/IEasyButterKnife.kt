package com.tikou.moduleibuttterknife

import android.util.Log
import android.view.View
import java.lang.reflect.Constructor

/**

 * @Author Administrator
 * @Date 2022/6/20-10:24
 * @Email wangweitikou1994@gmail.com
 * @Des
 */
object IEasyButterKnife {
    private val BINDINGS = LinkedHashMap<Class<*>, Constructor<out UnEasyBinder>?>()
    fun bind(target: Any, source: View): UnEasyBinder {
        val constructor = findBindingConstructorForClass(target.javaClass)
        return constructor?.newInstance(target, source) ?: UnEasyBinder.EMPTY
    }

    private fun findBindingConstructorForClass(clazz: Class<*>): Constructor<out UnEasyBinder>? {
        var constructor = BINDINGS[clazz]
        if (constructor != null) {
            return constructor
        }
        val className = clazz.name
        if (className.startsWith("android.") || className.startsWith("androidx.") ||
            className.startsWith("java.")
        ) {
            return null
        }
        constructor = try {
            val bindingClassName = className + "Binding"
            val bindingClass = clazz.classLoader.loadClass(bindingClassName)
            bindingClass.getDeclaredConstructor(
                clazz,
                View::class.java
            ) as Constructor<out UnEasyBinder>
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
            findBindingConstructorForClass(clazz.superclass)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
        BINDINGS[clazz] = constructor
        return constructor
    }
}