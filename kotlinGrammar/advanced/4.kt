package com.example.lab3

fun change(my_str:String):String{
    // 인자로 받은 String 을 MutableList 로 바꿈.
    val string_list = my_str.toMutableList()
    // 소문자를 변환한 대문자가 담길 new_str
    var new_str = ""
    // 소문자를 입력받지 않아 값 그대로 담길 error_str
    var error_str = ""
    for (i in string_list){
        // A~Z는 65~90, a~z는 97~122
        if (i.toInt()>=97 && i.toInt()<=122) {
            new_str+=(i.toInt()-32).toChar()
        }
        else {
            error_str+=i
        }
    }
    if (error_str == "") return new_str // error_str 에 아무 값도 넘어오지 않았다면
    else return "error with = " + error_str
}
fun main() {
    var a = "abcd"
    println(change(a))
    var b = "EfgH"
    println(change(b))
    var c = "!@%$"
    println(change(c))
}