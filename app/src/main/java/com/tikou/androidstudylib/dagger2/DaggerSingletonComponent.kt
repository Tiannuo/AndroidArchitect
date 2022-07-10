package com.tikou.androidstudylib.dagger2

import dagger.Component
import javax.inject.Singleton

/**
 * @Author TIKOU
 * @Date 2022/7/10-11:27
 * @Email 1320917731@qq.com & wangweitikou1994@gmail.com
 * @Description
 */
@Singleton
@Component(modules = [HttpDataModule::class])
interface DaggerSingletonComponent {
    public fun injectActivity(activity: DaggerActivity)
    public fun injectActivity2(activity: DaggerActivity2)
}