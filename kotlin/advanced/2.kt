package com.example.lab3

import java.lang.NumberFormatException

class ScoreInvalidException(message: String): Exception(message)

fun gradeFunc(score:Int):String{
    if (score>100||score<0){
        throw ScoreInvalidException("0~100의 범위를 넘었습니다.")
    }
    return when(score) {
        in 90..100 -> "A"
        in 80..90 -> "B"
        in 70..80 -> "C"
        in 60..70 -> "D"
        else -> "F"
    }
}

fun main() {
    try{
        println("시험점수를 입력하세요")
        val score = readLine()!!.toInt()

        val grade = gradeFunc(score)
        println("${score} : ${grade}등급")
    }catch (e:NumberFormatException) {
        println("형 반환이 불가능합니다.")
    }catch (e:ScoreInvalidException) {
        println(e.message)
    }finally {
        println("프로그램 종료")
    }
}