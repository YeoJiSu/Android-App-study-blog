package com.example.keypad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var btn1 : Button;
    lateinit var btn2 : Button;
    lateinit var btn3 : Button;
    lateinit var btn4 : Button;
    lateinit var btn5 : Button;
    lateinit var btn6 : Button;
    lateinit var btn7: Button;
    lateinit var btn8 : Button;
    lateinit var btn9 : Button;
    lateinit var btn10 : Button;
    lateinit var btn11 : Button;
    lateinit var btn12 : Button;
    lateinit var editText: EditText;
    lateinit var imageView: ImageView;
    lateinit var result: String;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.button1)
        btn2 = findViewById(R.id.button2)
        btn3 = findViewById(R.id.button3)
        btn4 = findViewById(R.id.button4)
        btn5 = findViewById(R.id.button5)
        btn6 = findViewById(R.id.button6)
        btn7 = findViewById(R.id.button7)
        btn8 = findViewById(R.id.button8)
        btn9 = findViewById(R.id.button9)
        btn10 = findViewById(R.id.button10)
        btn11 = findViewById(R.id.button11)
        btn12 = findViewById(R.id.button12)
        editText = findViewById(R.id.edit1)
        imageView = findViewById(R.id.imageView6)
        result = ""

        fun addNum(str:String) {
            if (result.length==3 || result.length==8)
                result+="-"
            result+=str
            editText.setText(result)
        }
        fun deleteNum(){
            if (result.isNotEmpty()){
                if (result.length==5 || result.length==10)
                    result = result.substring(0,result.length-2)
                else
                    result = result.substring(0,result.length-1)
                editText.setText(result)
            }
        }
        btn1.setOnClickListener{
            addNum("1")
        }
        btn2.setOnClickListener{
            addNum("2")
        }
        btn3.setOnClickListener{
            addNum("3")
        }
        btn4.setOnClickListener{
            addNum("4")
        }
        btn5.setOnClickListener{
            addNum("5")
        }
        btn6.setOnClickListener{
            addNum("6")
        }
        btn7.setOnClickListener{
            addNum("7")
        }
        btn8.setOnClickListener{
            addNum("8")
        }
        btn9.setOnClickListener{
            addNum("9")
        }
        btn10.setOnClickListener{
            addNum("*")
        }
        btn11.setOnClickListener{
            addNum("0")
        }
        btn12.setOnClickListener{
            addNum("#")
        }
        imageView.setOnClickListener{
            deleteNum()
        }
    }
}