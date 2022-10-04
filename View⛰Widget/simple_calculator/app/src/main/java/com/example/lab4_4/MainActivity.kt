package com.example.lab4_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.round
class MainActivity : AppCompatActivity() {
    lateinit var edit1 : EditText; lateinit var edit2 : EditText
    lateinit var btnAdd : Button; lateinit var btnSub :Button
    lateinit var btnMul : Button; lateinit var btnDiv: Button
    lateinit var btnMod : Button; lateinit var btnChg:Button
    lateinit var textResult: TextView
    lateinit var num1:String; lateinit var num2:String
    var result : Float? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 몇 회 계산인지 담을 변수 선언
        var count : Int = 0
        title = count.toString() + "회 계산기"

        edit1 = findViewById<EditText>(R.id.Edit1)
        edit2 = findViewById<EditText>(R.id.Edit2)

        btnAdd = findViewById<Button>(R.id.BtnAdd)
        btnSub = findViewById<Button>(R.id.BtnSub)
        btnMul = findViewById<Button>(R.id.BtnMul)
        btnDiv = findViewById<Button>(R.id.BtnDiv)
        btnMod = findViewById<Button>(R.id.BtnMod)
        btnChg = findViewById<Button>(R.id.BtnChg)

        textResult = findViewById<TextView>(R.id.TextResult)

        btnAdd.setOnTouchListener{ view, motionEvent ->
            // trim() 함수를 이용해 양쪽 끝부분 공백 제거
            num1 = edit1.text.toString().trim()
            num2 = edit2.text.toString().trim()
            // try 문 이용해 toInt()함수에 대한 예외 처리 => 숫자아닌 문자 입력 방지
            try {
                result = round(num1.toFloat() + num2.toFloat())
                textResult.text = "계산 결과 : " + result.toString()
                edit1.setText(result.toString())
                edit2.setText("")
                edit2.setSelection(0)
                // 계산 횟수 증가
                count+=1
                title = count.toString() + "회 계산기"

            } catch (e: NumberFormatException) {

            }
            false
        }
        btnSub.setOnTouchListener{ view, motionEvent ->
            num1 = edit1.text.toString().trim()
            num2 = edit2.text.toString().trim()
            try {
                result = round(num1.toFloat() - num2.toFloat())
                textResult.text = "계산 결과 : " + result.toString()
                edit1.setText(result.toString())
                edit2.setText("")
                edit2.setSelection(0)
                count+=1
                title = count.toString() + "회 계산기"
            } catch (e: NumberFormatException) {

            }
            false
        }
        btnMul.setOnTouchListener{ view, motionEvent ->
            num1 = edit1.text.toString().trim()
            num2 = edit2.text.toString().trim()
            try {
                result = round(num1.toFloat() * num2.toFloat())
                textResult.text = "계산 결과 : " + result.toString()
                edit1.setText(result.toString())
                edit2.setText("")
                edit2.setSelection(0)
                count+=1
                title = count.toString() + "회 계산기"
            } catch (e: NumberFormatException) {

            }
            false
        }
        btnDiv.setOnTouchListener{ view, motionEvent ->
            num1 = edit1.text.toString().trim()
            num2 = edit2.text.toString().trim()
            // 0으로 나눈 몫을 구하는 건 처리되지 않도록
            if (num2 == "0") {
                Toast.makeText(this@MainActivity, "ERROR! 0으로 나눈 나머지를 구할 수 없습니다!", Toast.LENGTH_SHORT).show()
            }
            else {
                try {
                    result = round(num1.toFloat() / num2.toFloat())
                    textResult.text = "계산 결과 : " + result.toString()
                    edit1.setText(result.toString())
                    edit2.setText("")
                    edit2.setSelection(0)
                    count+=1
                    title = count.toString() + "회 계산기"
                } catch (e: NumberFormatException) {

                }
            }
            false
        }
        btnMod.setOnTouchListener{ view, motionEvent ->
            num1 = edit1.text.toString().trim()
            num2 = edit2.text.toString().trim()
            // 0으로 나눈 나머지를 구하는 건 처리되지 않도록
            if (num2 == "0") {
                Toast.makeText(this@MainActivity, "ERROR! 0으로 나눈 몫을 구할 수 없습니다!", Toast.LENGTH_SHORT).show()
            }
            else {
                try {
                    result = round(num1.toFloat() % num2.toFloat())
                    textResult.text = "계산 결과 : " + result.toString()
                    edit1.setText(result.toString())
                    edit2.setText("")
                    edit2.setSelection(0)
                    count += 1
                    title = count.toString() + "회 계산기"
                } catch (e: NumberFormatException) {

                }
            }
            false
        }
        // setOnTouchListener 함수 쓰면 스위치 두번 일어나서 setOnClickListener 함수 사용함.
        btnChg.setOnClickListener{ view->
            num1 = edit1.text.toString().trim()
            num2 = edit2.text.toString().trim()
            try {
                var chg1 = num1.toFloat()
                var chg2 = num2.toFloat()
                edit1.setText(chg2.toString())
                edit2.setText(chg1.toString())
                edit2.setSelection(0)
                // 교체 버튼은 title의 count 횟수가 변하지 않음.
            } catch (e: NumberFormatException) {

            }
            false
        }

    }
}