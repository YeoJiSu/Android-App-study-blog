package com.example.lab6_3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        val txt1 :TextView = findViewById(R.id.textView6)
        val txt2 :TextView = findViewById(R.id.textView7)
        val txt3 :TextView = findViewById(R.id.textView8)
        val txt4 :TextView = findViewById(R.id.textView9)
        val btn: Button =findViewById(R.id.btn)

        val name = intent.getStringExtra("name")
        val age = intent.getStringExtra("age")
        val num = intent.getStringExtra("num")
        val add = intent.getStringExtra("add")
        val etc = intent.getStringExtra("etc")

        txt1.setText("이름 : " +name.toString()+"나이: "+age.toString())
        txt2.setText("연락처 : "+num.toString())
        txt3.setText("주소 : " +add.toString())
        txt4.setText("기타 : " +etc.toString())

        btn.setOnClickListener{
            val returnIntent: Intent = intent
            setResult(Activity.RESULT_OK,returnIntent)
            finish()
        }
    }

}