package com.example.lab4_5

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    lateinit var linLayer : LinearLayout;
    lateinit var btn : Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linLayer = findViewById<LinearLayout>(R.id.LinLay)
        btn =  findViewById<Button>(R.id.Btn)
var color = 0
        btn.setOnClickListener{
            val color1 = "#00FF00"
            val color2 = "#0000FF"
            val color3 = "#FF0000"
            color+=1
            if (color%3==1) linLayer.setBackgroundColor(Color.parseColor(color1))
            if (color%3==2) linLayer.setBackgroundColor(Color.parseColor(color2))
            if (color%3==0) linLayer.setBackgroundColor(Color.parseColor(color3))

        }
    }
}