package com.example.lab6_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn : Button = findViewById(R.id.btn)
        btn.setOnClickListener{

            val intent = Intent(this, SubActivity::class.java)
            intent.putExtra("data1","SubActivity")
            intent.putExtra("data2",10)
            startActivity(intent) // 화면 전환을 시켜줌.
//            finish() // main 창을 닫아줌.
        }
    }

}