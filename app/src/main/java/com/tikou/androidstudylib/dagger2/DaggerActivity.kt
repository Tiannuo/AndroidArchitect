package com.tikou.androidstudylib.dagger2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.orhanobut.logger.Logger
import com.tikou.androidstudylib.MyApp
import com.tikou.androidstudylib.R
import com.tikou.androidstudylib.di.Presenter
import javax.inject.Inject

class DaggerActivity : AppCompatActivity() {
    @Inject
    lateinit var httpDataObject1: HttpDataObject

    @Inject
    lateinit var httpDataObject2: HttpDataObject

    @Inject
    lateinit var presenter1: Presenter

    @Inject
    lateinit var presenter2: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger)
        // dagger注入方式一
        //DaggerDaggerComponent.create().injectActivity(this)
        //全局单例注入
        (application as MyApp).getDaggerSingleComponent().injectActivity(this)
        Logger.i("DaggerActivityCode" + httpDataObject1.hashCode())
        Logger.i("DaggerActivityCode" + httpDataObject2.hashCode())
        findViewById<View>(android.R.id.content).postDelayed(Runnable {
            val intent = Intent(this@DaggerActivity, DaggerActivity2::class.java)
            startActivity(intent)
        }, 2000)
    }

    override fun onPause() {
        super.onPause()
        httpDataObject1.str = "onPause"
        Logger.i("DaggerActivityCode" + httpDataObject2.str)
        Logger.i("DaggerActivityCode" + httpDataObject2.str)
        Logger.i("DaggerActivityCode" + presenter1.hashCode())
        Logger.i("DaggerActivityCode" + presenter2.hashCode())
        Logger.i("DaggerActivityCode onPause")
    }

}