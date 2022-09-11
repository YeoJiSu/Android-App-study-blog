package com.example.lab6_hw

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import java.lang.Exception

class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        val btn2: Button = findViewById(R.id.btn2)
        val txt1: TextView = findViewById(R.id.view1)
        val txt2: TextView = findViewById(R.id.view2)
        val txt3: TextView = findViewById(R.id.view3)
        val txt4: TextView = findViewById(R.id.view4)
        val txt5: TextView = findViewById(R.id.view5)
        val imageView : ImageView = findViewById(R.id.imageView)

        val k_name = intent.getStringExtra("k_name")
        val e_name = intent.getStringExtra("e_name")
        val phone = intent.getStringExtra("phone")
        val email = intent.getStringExtra("email")
        val college = intent.getStringExtra("college")
//        val bitmap = intent.getParcelableExtra<Bitmap>("image")
//        imageView.setImageBitmap(bitmap)

        try {
            val byteArray = intent.getByteArrayExtra("image")
            val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray!!.size)
            imageView.setImageBitmap(bitmap)
        }catch (e : Exception){
        }


        txt1.setText(k_name.toString())
        txt2.setText(e_name.toString())
        txt3.setText(phone.toString())
        txt4.setText(email.toString())
        txt5.setText(college.toString())

        // 수정 누르면 메인화면 돌아가게
        btn2.setOnClickListener{
            val returnIntent: Intent = intent
            setResult(Activity.RESULT_OK,returnIntent)
            finish()
        }


    }
}