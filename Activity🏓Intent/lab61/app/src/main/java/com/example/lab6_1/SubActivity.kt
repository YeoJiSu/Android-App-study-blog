package com.example.lab6_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        val text_sub:TextView = findViewById(R.id.text_sub)
        if(intent.hasExtra("data1")){
            text_sub.setText( intent.getStringExtra("data1"))
        }
    }
}