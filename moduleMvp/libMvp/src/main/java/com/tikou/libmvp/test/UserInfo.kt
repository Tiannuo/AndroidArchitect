package com.tikou.libmvp.test

/**

 * @Author Administrator
 * @Date 2022/6/14-16:23
 * @Email wangweitikou1994@gmail.com
 * @Des var写上变量var才可以做声明变量，下文才能引用，否则不行
 */
class UserInfo(var au_nickname: String, var au_sex: String) {
    override fun toString(): String {
        return "UserInfo(au_nickname='$au_nickname', au_sex='$au_sex')"
    }
}