package com.tikou.androidstudylib

import android.app.Application
import com.tikou.androidstudylib.dagger2.DaggerDaggerSingletonComponent
import com.tikou.androidstudylib.dagger2.DaggerSingletonComponent
import com.tikou.androidstudylib.dagger2.HttpDataModule

/**
 * @Author TIKOU
 * @Date 2022/7/10-11:25
 * @Email 1320917731@qq.com & wangweitikou1994@gmail.com
 * @Description
 */
class MyApp : Application() {
    //DaggerSingletonComponent 持有的 module中的被Singleton修饰的对象数据全局共享，相当于于一个静态量
    private var daggerSingleComponent: DaggerSingletonComponent =
        DaggerDaggerSingletonComponent.builder()
            .httpDataModule(HttpDataModule())
            .build()

    fun getDaggerSingleComponent() = daggerSingleComponent
}