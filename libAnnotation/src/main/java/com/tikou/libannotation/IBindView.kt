package com.tikou.libannotation

/**

 * @Author Administrator
 * @Date 2022/6/15-8:58
 * @Email wangweitikou1994@gmail.com
 * @Des
 */
@Target(AnnotationTarget.FIELD, AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.BINARY)
annotation class IBindView(val value: Int) {
}