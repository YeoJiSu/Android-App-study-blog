package com.example.lab3

open class Beverage() {
    open fun drink(money: Int): Int {
        println("슈퍼클래스의 drink 함수")
        return money
    }
}
class Cola(var taxRate: Double, operation: (Double)-> Double) : Beverage() {
    var price = 600
    var tax = operation(taxRate)
    override fun drink(money: Int): Int {
        println("콜라를 마십니다.")
        return money - this.price - this.tax.toInt()
    }
}

fun Cola.reset_cost(cost: Int) {
    price = cost
}

fun main() {
    var num1 = "3"
    var num2 = ""
    try {
        println(num1.toInt())
    } catch (e: NumberFormatException) {
        println("숫자를 입력하세요")
    }
//    var sub1 = Cola(10.0){taxRate->
//        33.0*(taxRate/100.0)
//    }
//    println("잔돈 : ${sub1.drink(2000)}")
//
//    sub1.reset_cost(300)
//    println("잔돈 : ${sub1.drink(2000)}")
}