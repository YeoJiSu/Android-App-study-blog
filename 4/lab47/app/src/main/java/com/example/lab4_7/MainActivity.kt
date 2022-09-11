package com.example.lab4_7

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var btnLeft : Button;
    lateinit var btnRight : Button;
    lateinit var img: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        img = findViewById<ImageView>(R.id.imgView)
        btnLeft = findViewById<Button>(R.id.BtnLeft)
        btnRight = findViewById<Button>(R.id.BtnRight)

        var start = 1
        fun click( sta : Int) {
            when (sta) {
                1 -> img.setImageResource(R.drawable.a)
                2 -> img.setImageResource(R.drawable.b)
                3 -> img.setImageResource(R.drawable.c)
                4 -> img.setImageResource(R.drawable.d)
                5 -> img.setImageResource(R.drawable.e)
                6 -> img.setImageResource(R.drawable.f)
                7 -> img.setImageResource(R.drawable.g)
                8 -> img.setImageResource(R.drawable.h)
                9 -> img.setImageResource(R.drawable.i)
                10 -> img.setImageResource(R.drawable.j)
                11 -> img.setImageResource(R.drawable.k)
                12 -> img.setImageResource(R.drawable.l)
                13 -> img.setImageResource(R.drawable.m)
                14 -> img.setImageResource(R.drawable.n)
                15 -> img.setImageResource(R.drawable.o)
                16 -> img.setImageResource(R.drawable.p)
                17 -> img.setImageResource(R.drawable.q)
                18 -> img.setImageResource(R.drawable.r)
                19 -> img.setImageResource(R.drawable.s)
                20 -> img.setImageResource(R.drawable.t)
                21 -> img.setImageResource(R.drawable.u)
                22 -> img.setImageResource(R.drawable.v)
                23 -> img.setImageResource(R.drawable.w)
                24 -> img.setImageResource(R.drawable.s)
                25 -> img.setImageResource(R.drawable.y)
                26 -> img.setImageResource(R.drawable.z)
            }
        }
        btnLeft.setOnClickListener {
            start -= 1
            if (start == 0) {
                start = 26
                img.setImageResource(R.drawable.z)
            }
            else {
                click(start)
            }

        }
        btnRight.setOnClickListener{
            start+= 1
            if (start == 27) {
                // start 값을 초기화
                start = 1
                img.setImageResource(R.drawable.a)
            }
            else {
                click(start)
            }
        }
    }
}