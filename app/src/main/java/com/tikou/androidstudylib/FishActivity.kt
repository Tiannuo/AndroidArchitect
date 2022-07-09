package com.tikou.androidstudylib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.tikou.seniorui.fish.FishDrawable

class FishActivity : AppCompatActivity() {
    private lateinit var iv_fish:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fish)
        iv_fish = findViewById(R.id.iv_fish)
        iv_fish.setImageDrawable(FishDrawable())
    }
}