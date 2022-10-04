package com.example.lab2_1

import java.util.*

val sc: Scanner = Scanner(System.`in`)

enum class Grade{A,B,C,D,E,F}

class MyAccount(){
    val my_name = "Kit" // 이름
    var my_balance = 0 // 초기 계좌 잔액
    var my_grade = Grade.C // 초기 신용 등급
    var if_account_freeze = 0 // 계좌 동결 여부

    fun Deposite() {
        println("입금하실 금액을 말하세요.")
        val money = sc.nextLine().toInt()
        my_balance += money
        if (my_balance >= 0) { // 계좌 잔액 >= 0 이면
            if ( if_account_freeze == 1) {
                if_account_freeze = 0 // 계좌 동결 상태 해제
                println("동결계좌가 열렸습니다.")
            }
            upGrade(my_grade) //신용등급 상승
        }
        println("${money} 원을 입금하였습니다. 잔액 : ${my_balance}")
    }

    fun Withdraw() {
        if (if_account_freeze == 1) {
            println("동결된 계좌에서 출금하실 수 없습니다.")
            return // 함수 종료
        }
        println("출금하실 금액을 말하세요.")
        var money = sc.nextLine().toInt()
        my_balance -= money

        if (my_grade == Grade.F) {
            println("최저 등급의 신용을 가지고 있습니다.\n계좌가 동결됩니다.")
            if_account_freeze = 1
            my_balance += money // 동결된 상태가 되면은 출금 안되게
            return
        }

        if (my_balance < -1000) {
            println("ERROR 잔액이 부족합니다 !")
            my_balance += money // 잔액 부족하면 출금 안되게
            return
        }

        else if (my_balance < 0) {
            downGrade(my_grade)
        }
        println("계좌가 마이너스 되었습니다.")
        println("${money} 원을 출금하였습니다. 잔액:${my_balance}")
    }

    fun downGrade(grade: Grade) {
        when (grade) {
            Grade.A -> my_grade = Grade.B
            Grade.B -> my_grade = Grade.C
            Grade.C -> my_grade = Grade.D
            Grade.D -> my_grade = Grade.E
            Grade.E -> my_grade = Grade.F
        }
        if (grade !== Grade.F) println("신용등급이 '${grade}->${my_grade}'로 한단계 떨어집니다.")
    }

    fun upGrade(grade: Grade) {
        when (grade) {
            Grade.B -> my_grade = Grade.A
            Grade.C -> my_grade = Grade.B
            Grade.D -> my_grade = Grade.C
            Grade.E -> my_grade = Grade.D
            Grade.F -> my_grade = Grade.E
        }
        if (grade !== Grade.A) println("신용등급이 '${grade}->${my_grade}'로 한단계 상승합니다.")
    }


}

fun main(){

    var myAccount = MyAccount()
    while (true){
        println("----선택하시오----\n" +
                "|(I) 계좌정보    |\n"+
                "|(D) 입금       |\n"+
                "|(W) 출금       |\n"+
                "|(E) 종료       |\n"+
                "---------------"
        )
        val input =sc.nextLine().toString()
        if (input == "I") { // 계좌정보
            println("계좌정보는 다음과 같습니다.\n" +
                    "|이름:     ${myAccount.my_name} |\n"+
                    "|계좌잔액:   ${myAccount.my_balance} |\n"+
                    "|신용등급:   ${myAccount.my_grade}  |"+
                    "\n\n"
            )
        }
        else if (input == "D") { // 입금
            myAccount.Deposite()
        }
        else if (input == "W") { // 출금
            myAccount.Withdraw()
        }
        else if (input == "E") break
        else println("잘못된 입력입니다.")
    }
}