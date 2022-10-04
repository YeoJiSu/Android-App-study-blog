package com.example.lab6_2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        val text_view: TextView = findViewById(R.id.textView3)
        val btn_close : Button = findViewById(R.id.btn_close)
        val data = intent.getStringExtra("data")
        text_view.setText(data.toString()+"\n-send from main")

        val text_view2: EditText = findViewById(R.id.textView2)
        btn_close.setOnClickListener {
            //intent 객체를 돌려줄 때는 target을 따로 설정하지 않습니다.
            val returnIntent: Intent = intent
            intent.putExtra("data",text_view2.getText().toString())

            //setResult를 이용하여 돌려줍니다.
            //첫번쨰 인자는 성공실패 여부를 보내는 구분값으로 사용 됩니다.
            setResult(Activity.RESULT_OK,returnIntent)
            finish()
        }
    }
}