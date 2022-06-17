package com.tikou.libannotation

/**

 * @Author Administrator
 * @Date 2022/6/17-19:18
 * @Email wangweitikou1994@gmail.com
 * @Des
 */
@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.FUNCTION)
annotation class OnClick(vararg val values: Int) {
}