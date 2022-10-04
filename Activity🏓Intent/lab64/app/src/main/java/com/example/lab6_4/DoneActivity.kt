package com.example.lab6_4

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class DoneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_done)
        Toast.makeText(this, "저장 완료", Toast.LENGTH_SHORT).show()
        val txt1 : TextView = findViewById(R.id.textView6)
        val txt2 : TextView = findViewById(R.id.textView7)
        val txt3 : TextView = findViewById(R.id.textView8)
        val txt4 : TextView = findViewById(R.id.textView9)

        val name = intent.getStringExtra("name")
        val age = intent.getStringExtra("age")
        val num = intent.getStringExtra("num")
        val add = intent.getStringExtra("add")
        val etc = intent.getStringExtra("etc")

        val imageView : ImageView = findViewById(R.id.imageView)
        val byteArray = intent.getByteArrayExtra("image")
        val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray!!.size)
        imageView.setImageBitmap(bitmap)

        txt1.setText("이름 : " +name.toString()+" 나이: "+age.toString())
        txt2.setText("연락처 : "+num.toString())
        txt3.setText("주소 : " +add.toString())
        txt4.setText("메모 : " +etc.toString())
    }
}