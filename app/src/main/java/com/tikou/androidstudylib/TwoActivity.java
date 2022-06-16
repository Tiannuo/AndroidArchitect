package com.tikou.androidstudylib;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tikou.libannotation.IBindView;

/**
 * @Author Administrator
 * @Date 2022/6/16-11:44
 * @Email wangweitikou1994@gmail.com
 * @Des
 */
public class TwoActivity extends AppCompatActivity {

    @IBindView(R.id.tv_hello)
    TextView tv_hello;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
