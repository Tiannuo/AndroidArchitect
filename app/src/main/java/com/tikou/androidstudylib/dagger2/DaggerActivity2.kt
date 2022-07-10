package com.tikou.androidstudylib.dagger2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.orhanobut.logger.Logger
import com.tikou.androidstudylib.R
import javax.inject.Inject

class DaggerActivity2 : AppCompatActivity() {
    @Inject
    lateinit var httpDataObject3: HttpDataObject
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger2)
        //DaggerDaggerComponent2.create().injectActivity(this)
        // dagger注入方式一
        DaggerDaggerComponent2.builder().httpDataModule(HttpDataModule())
            .build().injectActivity(this)
        Logger.i("DaggerActivity2Code" + httpDataObject3.hashCode())
    }
}