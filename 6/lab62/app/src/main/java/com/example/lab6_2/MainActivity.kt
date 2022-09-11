package com.example.lab6_2

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

        val btn : Button = findViewById(R.id.btn)
        val ev : EditText = findViewById(R.id.textView2)
        val res: TextView = findViewById(R.id.textView3)

        btn.setOnClickListener{
            if (ev.text.isEmpty()){
                Toast.makeText(this, "값을 입력 해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val data :String = ev.text.toString()
            val intent = Intent(this, SubActivity::class.java)
            intent.putExtra("data",data)
            startActivityForResult(intent,100) //intent 에 저장되어 있는 액티비티 쪽으로 이동한다.
            ev.text = null
        }
    }
    // 서브 액티비티 에서 돌려준 intent 를 받기위한 함수
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val res : TextView = findViewById(R.id.textView3)
        //서브 액티비티 에서 정상적으로 데이터가 넘어 왔는지 확인하는 코드
        if(resultCode == Activity.RESULT_OK){
            //startActivityForResult를 사용하여 보낸 reqeustCode를 확인하기 위한 코드
            when(requestCode){
                100 -> {
                    res.text = data!!.getStringExtra("data").toString()+"\n-send from sub"

                }
            }
        }

    }

}

