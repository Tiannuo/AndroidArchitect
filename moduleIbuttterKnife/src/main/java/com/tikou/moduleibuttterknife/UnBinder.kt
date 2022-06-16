package com.tikou.moduleibuttterknife

import androidx.annotation.UiThread

/**

 * @Author Administrator
 * @Date 2022/6/15-15:34
 * @Email wangweitikou1994@gmail.com
 * @Des
 */
interface UnBinder {
    @UiThread
    fun unBind()

    companion object {
        val EMPTY: UnBinder = object : UnBinder {
            override fun unBind() {}
        }
    }
}