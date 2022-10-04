package com.example.lab2_1

fun Year(number:Int):Int{
    var number = number
    if (number%4 == 0 && (number%100 !==0 || number%400==0))
        return 1 // 윤년
    return 0
}
fun printer(number: Int) {
    if (number == 1) println("윤년이 맞습니다.")
    else if (number == 0) println("윤년이 아닙니다.")
}

fun main(){
    println("2000년은 윤년 일까?")
    printer(Year(2000))

    println("1900년은 윤년 일까?")
    printer(Year(1900))

    println("2020년은 윤년 일까?")
    printer(Year(2020))

    println("2013년은 윤년 일까?")
    printer(Year(2013))
}