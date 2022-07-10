package com.tikou.androidstudylib.di

import com.tikou.androidstudylib.dagger2.scope.UserScope
import dagger.Component
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @Author TIKOU
 * @Date 2022/7/10-12:54
 * @Email 1320917731@qq.com & wangweitikou1994@gmail.com
 * @Description
 */
@UserScope
@Component(modules = [PresenterModule::class])
interface PresenterComponent {

    public fun providerPresenter(): Presenter
}