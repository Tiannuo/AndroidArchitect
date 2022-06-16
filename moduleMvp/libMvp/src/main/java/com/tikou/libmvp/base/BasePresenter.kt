package com.tikou.libmvp.base

import java.lang.ref.WeakReference
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

/**

 * @Author Administrator
 * @Date 2022/6/14-14:58
 * @Email wangweitikou1994@gmail.com
 * @Des
 */
open class BasePresenter<V : BaseView> {
    private var mViewReference: WeakReference<V>? = null
    private var mProxyView: V? = null

    public fun attach(v: V) {
        this.mViewReference = WeakReference<V>(v)
        mProxyView = Proxy.newProxyInstance(
            v.javaClass.classLoader,
            v.javaClass.interfaces,
            object : InvocationHandler {
                override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any? {
                    if (mViewReference == null || mViewReference!!.get() == null) {
                        return null
                    }
                    if (method != null) {
                        return method.invoke(mViewReference!!.get(), args)
                    }
                    return null
                }

            }) as V?
    }

    public fun detach() {
        this.mViewReference?.clear()
        this.mViewReference = null
        this.mProxyView = null
    }

    public fun getView(): V? = mProxyView
}