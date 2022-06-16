package com.tikou.libmvp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**

 * @Author Administrator
 * @Date 2022/6/14-14:57
 * @Email wangweitikou1994@gmail.com
 * @Des
 */
abstract class BaseMvpActivity<P : BasePresenter<V>, V : BaseView> : AppCompatActivity(), BaseView {
    private var p: P? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        p = createPresenter()
        p?.attach(this as V)
        initView()
        initData()
    }

    abstract fun createPresenter(): P?
    abstract fun initView()
    abstract fun initData()


    override fun onDestroy() {
        super.onDestroy()
        p?.detach()
    }

    public fun getPresenter() = p
}