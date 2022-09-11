package com.example.lab2_1
class Calculator(){
    var datas = ArrayList<Double>()
    var error = 0
    private fun add(a:Double, b:Double){datas.add(a+b)}
    private fun substract(a:Double, b:Double){datas.add(a-b)}
    private fun multiple(a:Double, b:Double){datas.add(a*b)}
    private fun division(a:Double, b:Double){datas.add(a/b)}

    fun load(){
        for (i in datas) println(i)
    }

    fun cal(a:Double, b:Double, type:String){
        error = 0
        if (type == "add") add(a,b)
        else if (type == "substract") substract(a,b)
        else if (type == "multiple") multiple(a,b)
        else if (type == "division") {
            if (b == 0.0) error = 1
            else division(a,b)
        }
    }

    fun print_calculated_number(){
        if (error == 1) println("ERROR : number can not be divided with zero.")
        println(datas.last()) // 미지막으로 들어온 원소 출력
    }
}
fun main(){
    var calculator = Calculator()
    calculator.cal(1.0,2.0,"add")
    calculator.print_calculated_number()
    calculator.cal(1.0,10.0,"substract")
    calculator.print_calculated_number()
    calculator.cal(1.0,0.0,"division")
    calculator.print_calculated_number()
    calculator.cal(1.0,10.0,"division")
    calculator.print_calculated_number()
    calculator.cal(1.0,10.0,"multiple")
    calculator.print_calculated_number()
    println("--------------------")
    calculator.load()
}