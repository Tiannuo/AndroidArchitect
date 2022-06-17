package com.tikou.androidstudylib

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.tikou.libannotation.IBindView
import com.tikou.moduleibuttterknife.Utils
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {


    @IBindView(R.id.tv_hello)
    @JvmField
    var tv_hello: TextView? = null

    @IBindView(R.id.tv_hello1)
    @JvmField
    var tv_hello2: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.tv_hello = Utils.findViewById(this,R.id.tv_hello)
    }
}