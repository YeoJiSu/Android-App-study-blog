package com.example.lab6_hw

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import java.io.ByteArrayOutputStream

val GALLERY = 1
class MainActivity : AppCompatActivity() {
    private fun openGallery(){
        val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.setType("image/*")
        startActivityForResult(intent,GALLERY)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn1: Button = findViewById(R.id.btn1)
        val k_name: EditText = findViewById(R.id.edit1)
        val e_name: EditText = findViewById(R.id.edit2)
        val phone: EditText = findViewById(R.id.edit3)
        val email: EditText = findViewById(R.id.edit4)
        val college: EditText = findViewById(R.id.edit5)
        val imageView : ImageView = findViewById(R.id.imageView)
        imageView.isClickable = true
        imageView.setOnClickListener{
            openGallery()
        }
        btn1.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            intent.putExtra("k_name", k_name.text.toString())
            intent.putExtra("e_name", e_name.text.toString())
            intent.putExtra("phone", phone.text.toString())
            intent.putExtra("email", email.text.toString())
            intent.putExtra("college", college.text.toString())

//            val bitmap = intent.getParcelableExtra<Bitmap>("image")
//            val resize = resizeBitmap(bitmap!!,300,300)
//            intent.putExtra("image",resize)

            val stream = ByteArrayOutputStream()

            try {
                val bitmap = (imageView.getDrawable() as BitmapDrawable).bitmap
                val resize = resizeBitmap(bitmap , 300,300)

                resize.compress(Bitmap.CompressFormat.JPEG, 100, stream)
                val byteArray: ByteArray = stream.toByteArray()
                intent.putExtra("image",byteArray)
                startActivityForResult(intent, 100) //intent 에 저장되어 있는 액티비티 쪽으로 이동한다.
            } catch (e : Exception){
                startActivityForResult(intent, 100) //intent 에 저장되어 있는 액티비티 쪽으로 이동한다.
            }

        }
    }

    private fun resizeBitmap(bitmap: Bitmap,width:Int,height:Int):Bitmap{
        return Bitmap.createScaledBitmap(
            bitmap,
            width,
            height,
            false
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                GALLERY -> {
                    var ImageData: Uri? =data?.data
                    try {
                        val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, ImageData)
                        val pt: ImageView = findViewById(R.id.imageView)
                        pt.setImageBitmap(bitmap)

                    }
                    catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        }

    }
}