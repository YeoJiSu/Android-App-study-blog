package com.example.lab6_4


import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.io.ByteArrayOutputStream


class MainActivity : AppCompatActivity() {

    private fun resizeBitmap(bitmap: Bitmap,width:Int,height:Int):Bitmap{
        return Bitmap.createScaledBitmap(
            bitmap,
            width,
            height,
            false
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val name: EditText = findViewById(R.id.editText)
        val age: EditText = findViewById(R.id.editText2)
        val num: EditText = findViewById(R.id.editText3)
        val add: EditText = findViewById(R.id.editText4)
        val etc: EditText = findViewById(R.id.editText5)
        val btn: Button = findViewById(R.id.btn)
        val imageView : ImageView = findViewById(R.id.imageView)
        imageView.isClickable = true
        imageView.setOnClickListener{
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivityForResult(intent, 200)
        }
        btn.setOnClickListener {
            val intent = Intent(this, FinishActivity::class.java)
            intent.putExtra("name", name.text.toString())
            intent.putExtra("age", age.text.toString())
            intent.putExtra("num", num.text.toString())
            intent.putExtra("add", add.text.toString())
            intent.putExtra("etc", etc.text.toString())

            val stream = ByteArrayOutputStream()
            val bitmap = (imageView.getDrawable() as BitmapDrawable).bitmap
            val scale = (1024 / bitmap.width.toFloat())
            val image_w = (bitmap.width * scale).toInt()
            val image_h = (bitmap.height * scale).toInt()
            val resize = Bitmap.createScaledBitmap(bitmap, image_w, image_h, true)
            resize.compress(Bitmap.CompressFormat.JPEG, 100, stream)
            val byteArray: ByteArray = stream.toByteArray()

            intent.putExtra("image", byteArray)
            startActivityForResult(intent, 100) //intent 에 저장되어 있는 액티비티 쪽으로 이동한다.

        }
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        //서브 액티비티 에서 정상적으로 데이터가 넘어 왔는지 확인하는 코드
        if (resultCode == Activity.RESULT_OK) {
            //startActivityForResult를 사용하여 보낸 reqeustCode를 확인하기 위한 코드
            when (requestCode) {
                200 -> {
                    var ImageData: Uri? =data?.data
                    try {
                        val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, ImageData)
                        val resize = resizeBitmap(bitmap , 300,300)
                        val pt: ImageView = findViewById(R.id.imageView)
                        pt.setImageBitmap(resize)

                    }
                    catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
                101 -> {
                    val name: EditText = findViewById(R.id.editText)
                    val age: EditText = findViewById(R.id.editText2)
                    val num: EditText = findViewById(R.id.editText3)
                    val add: EditText = findViewById(R.id.editText4)
                    val etc: EditText = findViewById(R.id.editText5)
                    val imageView : ImageView = findViewById(R.id.imageView)
                    name.setText("")
                    age.setText("")
                    num.setText("")
                    add.setText("")
                    etc.setText("")
                    imageView.setImageResource(0)

                }
            }
        }

    }
}
