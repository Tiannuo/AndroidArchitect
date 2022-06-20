package com.tikou.moduleibuttterknife

/**

 * @Author Administrator
 * @Date 2022/6/20-10:25
 * @Email wangweitikou1994@gmail.com
 * @Des
 */
interface UnEasyBinder {
    fun unBind()

    object EMPTY:UnEasyBinder{
        override fun unBind() {

        }
    }
}