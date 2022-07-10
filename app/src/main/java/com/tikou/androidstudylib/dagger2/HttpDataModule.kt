package com.tikou.androidstudylib.dagger2

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @Author TIKOU
 * @Date 2022/7/9-17:12
 * @Email 1320917731@qq.com & wangweitikou1994@gmail.com
 * @Description
 * @Module 用于提供数据类对象注解
 * @Provides 暴露需要注入的对象
 */
@Module
class HttpDataModule {
    //需要使用单例的具体对象使用Singleton ，其module不需要
    @Singleton
    @Provides
    public fun providerHttpObject(): HttpDataObject {
        return HttpDataObject()
    }
}