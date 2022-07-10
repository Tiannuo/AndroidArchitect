package com.tikou.androidstudylib.dagger2

import dagger.Component

import javax.inject.Singleton

/**
 * @Author TIKOU
 * @Date 2022/7/10-11:08
 * @Email 1320917731@qq.com & wangweitikou1994@gmail.com
 * @Description
 */
@Singleton
@Component(modules = [HttpDataModule::class])
interface DaggerComponent2 : BaseComponent<DaggerActivity2> {
}