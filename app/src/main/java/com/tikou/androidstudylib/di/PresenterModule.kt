package com.tikou.androidstudylib.di

import com.tikou.androidstudylib.dagger2.scope.UserScope
import dagger.Module
import dagger.Provides

/**
 * @Author TIKOU
 * @Date 2022/7/10-12:51
 * @Email 1320917731@qq.com & wangweitikou1994@gmail.com
 * @Description
 */
@Module
class PresenterModule {
    @UserScope
    @Provides
    public fun providerPresenter() = Presenter()
}