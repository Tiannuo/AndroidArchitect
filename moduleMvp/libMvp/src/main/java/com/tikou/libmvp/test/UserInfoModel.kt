package com.tikou.libmvp.test

import io.reactivex.rxjava3.core.Observable

/**

 * @Author Administrator
 * @Date 2022/6/14-16:30
 * @Email wangweitikou1994@gmail.com
 * @Des
 */
class UserInfoModel:UserInfoContract.UserInfoModel {
    override fun getUsers(token: String): Observable<UserInfo> {
            return Observable.just(UserInfo("zz","0"))
    }
}