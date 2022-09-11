package com.example.lab6_4

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.ByteArrayOutputStream


class FinishActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
        val txt1 : TextView = findViewById(R.id.textView6)
        val txt2 : TextView = findViewById(R.id.textView7)
        val txt3 : TextView = findViewById(R.id.textView8)
        val txt4 : TextView = findViewById(R.id.textView9)
        val btn: Button =findViewById(R.id.btn)
        val btn2: Button = findViewById(R.id.btn2)

        val imageView : ImageView = findViewById(R.id.imageView)

        val name = intent.getStringExtra("name")
        val age = intent.getStringExtra("age")
        val num = intent.getStringExtra("num")
        val add = intent.getStringExtra("add")
        val etc = intent.getStringExtra("etc")

        val byteArray = intent.getByteArrayExtra("image")
        val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray!!.size)
        imageView.setImageBitmap(bitmap)

        txt1.setText("이름 : " +name.toString()+" 나이: "+age.toString())
        txt2.setText("연락처 : "+num.toString())
        txt3.setText("주소 : " +add.toString())
        txt4.setText("메모 : " +etc.toString())

        // 수정 누르면 메인화면 돌아가게
        btn2.setOnClickListener{
            val returnIntent: Intent = intent
            setResult(Activity.RESULT_OK,returnIntent)
            finish()
        }
        // 완료를 누르면 완료 화면으로
        btn.setOnClickListener {
            val intent = Intent(this, DoneActivity::class.java)
            intent.putExtra("name", name.toString())
            intent.putExtra("age", age.toString())
            intent.putExtra("num", num.toString())
            intent.putExtra("add", add.toString())
            intent.putExtra("etc", etc.toString())

            val stream = ByteArrayOutputStream()
            val bitmap = (imageView.getDrawable() as BitmapDrawable).bitmap
            val scale = (1024 / bitmap.width.toFloat())
            val image_w = (bitmap.width * scale).toInt()
            val image_h = (bitmap.height * scale).toInt()
            val resize = Bitmap.createScaledBitmap(bitmap, image_w, image_h, true)
            resize.compress(Bitmap.CompressFormat.JPEG, 100, stream)
            val byteArray: ByteArray = stream.toByteArray()

            val intent2 = Intent(this, MainActivity::class.java)
            intent2.putExtra("finish","finish")
            startActivityForResult(intent2, 101)

            intent.putExtra("image", byteArray)
            startActivityForResult(intent, 100)



            finish()

        }
    }

}