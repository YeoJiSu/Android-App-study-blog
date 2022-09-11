package com.example.lab4_6

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btn1 : Button;
    lateinit var btn2 : Button;
    lateinit var btn3 : Button;
    lateinit var btn4 : Button;
    lateinit var btn5 : Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1 = findViewById<Button>(R.id.Btn1)
        btn2 = findViewById<Button>(R.id.Btn2)
        btn3 = findViewById<Button>(R.id.Btn3)
        btn4 = findViewById<Button>(R.id.Btn4)
        btn5 = findViewById<Button>(R.id.Btn5)

        btn1.setOnClickListener{
            btn1.visibility = View.INVISIBLE
            btn2.visibility = View.VISIBLE
            btn3.visibility = View.INVISIBLE
            btn4.visibility = View.INVISIBLE
            btn5.visibility = View.INVISIBLE
        }
        btn2.setOnClickListener{
            btn1.visibility = View.INVISIBLE
            btn2.visibility = View.INVISIBLE
            btn3.visibility = View.VISIBLE
            btn4.visibility = View.INVISIBLE
            btn5.visibility = View.INVISIBLE
        }
        btn3.setOnClickListener{
            btn1.visibility = View.INVISIBLE
            btn2.visibility = View.INVISIBLE
            btn3.visibility = View.INVISIBLE
            btn4.visibility = View.VISIBLE
            btn5.visibility = View.INVISIBLE
        }
        btn4.setOnClickListener{
            btn1.visibility = View.INVISIBLE
            btn2.visibility = View.INVISIBLE
            btn3.visibility = View.INVISIBLE
            btn4.visibility = View.INVISIBLE
            btn5.visibility = View.VISIBLE
        }
        btn5.setOnClickListener{
            btn1.visibility = View.VISIBLE
            btn2.visibility = View.INVISIBLE
            btn3.visibility = View.INVISIBLE
            btn4.visibility = View.INVISIBLE
            btn5.visibility = View.INVISIBLE
        }
    }
}