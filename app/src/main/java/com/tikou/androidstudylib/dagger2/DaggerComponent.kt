package com.tikou.androidstudylib.dagger2

import dagger.Component
import javax.inject.Singleton

/**
 * @Author TIKOU
 * @Date 2022/7/9-17:15
 * @Email 1320917731@qq.com & wangweitikou1994@gmail.com
 * @Description 组件用于管理其所属的@Module
 * @Component 组件需要接口定义interface DaggerComponent
 */
@Singleton
@Component(modules = [HttpDataModule::class])
interface DaggerComponent :BaseComponent<DaggerActivity>{
}