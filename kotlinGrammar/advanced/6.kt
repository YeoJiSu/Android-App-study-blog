package com.example.lab3

import java.util.*
val sc:Scanner = Scanner(System.`in`)

// 잔돈 반환하기
fun getChange(menu_value: Int, coin:Int): Int? {
    val changes = menu_value - coin

    if (changes>0) {
        println("현금이 부족합니다.")
        return null
    }
    else{
        println("감사합니다. 잔돈반환:${changes*-1}")
        return changes*-1
    }
}

// 돈 넣기
fun getCoin(my_menu: String): Int? {
    val menu_value = getPrice(my_menu)
    println("Insert coin")
    try {
        var coin = sc.nextLine().toInt()
        if (coin <=0) { // 올바르지 않은 금액일 때
            println("돈을 넣지 않았습니다.\n다시 돈을 넣어주세요.")
            return -1
        }
        else{
            println("${coin} 원을 넣었습니다.")
            getChange(menu_value!!,coin)
            return 1
        }
    } catch (e: Exception) { // 올바르지 않은 값일 때
        println("돈을 넣지 않았습니다.\n다시 돈을 넣어주세요.")
        return null
    }


}

// 메뉴 선택하고 반환하기
fun getMenu(): String? {

    println("============= 선택하시오 =============\n" +
            "| (1) 참깨라면        - 1,000원       |\n"+
            "| (2) 햄버거          - 1,500원       |\n"+
            "| (3) 콜라           -   800원       |\n"+
            "| (4) 핫바           - 1,200원       |\n"+
            "| (5) 초코우유        - 1,500원       |\n"+
            "Choose menu:"
    )
    val input =sc.nextLine().toString()
    val menu = arrayOf("1","2","3","4","5")

    if (input in menu){
        when(input){
            "1" -> println("참깨라면이 선택되었습니다.")
            "2" -> println("햄버거가 선택되었습니다.")
            "3" -> println("콜라가 선택되었습니다.")
            "4" -> println("핫바가 선택되었습니다.")
            "5" -> println("초코우유가 선택되었습니다.")
        }
        return input
    }
    else{
        // 아무것도 선택 되지 않을시 null 반환
        println("아무것도 선택하지 않았습니다.\n다시 선택해주세요.")
        return null
    }
}

// 선택한 메뉴의 가격정보 가져오기
fun getPrice(input:String?): Int? {
    when (input) {
        "1" -> return (1000)
        "2" -> return (1500)
        "3" -> return (800)
        "4" -> return (1200)
        "5" -> return (1500)
        else -> return(null)
    }
}

fun main() {
    while (true)
    {
        val myMenu = getMenu()
        // 메뉴선택 잘못되면 null 반환하여 처리하기
        if (myMenu == null) continue
        else {
            while (true)
            {
                val myCoin = getCoin(myMenu)
                //insert coin 선택 잘못되면 null 반환하여 처리하기
                if (myCoin == null || myCoin == -1) continue
                else break
            }
            break
        }
    }

}
