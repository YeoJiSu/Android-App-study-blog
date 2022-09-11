package com.example.lab6_3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val name: EditText = findViewById(R.id.editText)
        val age:EditText = findViewById(R.id.editText2)
        val num:EditText = findViewById(R.id.editText3)
        val add:EditText = findViewById(R.id.editText4)
        val etc:EditText = findViewById(R.id.editText5)
        val btn:Button =findViewById(R.id.btn)

        btn.setOnClickListener{
            val intent = Intent(this, SubActivity::class.java)
            intent.putExtra("name",name.text.toString())
            intent.putExtra("age",age.text.toString())
            intent.putExtra("num",num.text.toString())
            intent.putExtra("add",add.text.toString())
            intent.putExtra("etc",etc.text.toString())

            startActivityForResult(intent,100) //intent 에 저장되어 있는 액티비티 쪽으로 이동한다.
            name.text = null
            age.text = null
            num.text = null
            add.text = null
            etc.text = null
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val res : TextView = findViewById(R.id.textView3)
        //서브 액티비티 에서 정상적으로 데이터가 넘어 왔는지 확인하는 코드
        if(resultCode == Activity.RESULT_OK){
            //startActivityForResult를 사용하여 보낸 reqeustCode를 확인하기 위한 코드
            when(requestCode){
                100 -> {
//                    res.text = data!!.getStringExtra("data").toString()+"\n-send from sub"

                }
            }
        }

    }
}