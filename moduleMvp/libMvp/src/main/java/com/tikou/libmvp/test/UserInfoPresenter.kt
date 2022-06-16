package com.tikou.libmvp.test

import com.tikou.libmvp.base.BasePresenter

/**

 * @Author Administrator
 * @Date 2022/6/14-16:26
 * @Email wangweitikou1994@gmail.com
 * @Des
 */
class UserInfoPresenter : BasePresenter<UserInfoContract.UserInfoView>(),
    UserInfoContract.UserInfoPresenter {
    private var mModel: UserInfoContract.UserInfoModel? = null

    init {
        mModel = UserInfoModel()
    }

    override fun getUser(token: String) {

    }
}