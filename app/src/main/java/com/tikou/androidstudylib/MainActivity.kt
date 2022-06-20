package com.tikou.androidstudylib

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.tikou.libannotation.IBindView
import com.tikou.moduleibuttterknife.IEasyButterKnife


class MainActivity : AppCompatActivity() {

    @IBindView(R.id.tv_hello)
    @JvmField
    var tv_hello: TextView? = null

    @IBindView(R.id.tv_hello1)
    @JvmField
    var tv_hello2: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val root: View = LayoutInflater.from(this).inflate(R.layout.activity_main, null)
        setContentView(root)
        IEasyButterKnife.bind(this,root)
        tv_hello!!.text = "IBindView"
    }
}