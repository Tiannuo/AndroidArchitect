package com.tikou.libmvp.test

import com.tikou.libmvp.base.BaseView
import io.reactivex.rxjava3.core.Observable

/**

 * @Author Administrator
 * @Date 2022/6/14-16:18
 * @Email wangweitikou1994@gmail.com
 * @Des
 */
class UserInfoContract {
    interface UserInfoView : BaseView {
        fun onLoading()
        fun onLSucceed()
        fun onError()
    }

    interface UserInfoPresenter {
        fun getUser(token: String)
    }

    interface UserInfoModel{
        fun getUsers(token: String):Observable<UserInfo>
    }
}