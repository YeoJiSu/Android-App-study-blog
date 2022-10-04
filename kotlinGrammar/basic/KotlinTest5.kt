package com.example.lab2_1

import java.util.*

fun main() {
    var num = 0
    var pairList: MutableList<Int> = mutableListOf()

    val sc:Scanner = Scanner(System.`in`)
    num = sc.nextLine().toInt()

    for (i:Int in 0..num-1 step(1)) {
        var temp = sc.nextLine().toInt()
        pairList.add(temp)
    }
    for (i:Int in 0..num-1 step(1)){
        var my_pair = ""
        var x = 1
        var y = pairList[i]-1
        while (x < y) {
            var dot =","
            if (x == 1) dot = ""
            my_pair+= dot+"(${x} ${y})"
            x++
            y--
        }
        println("Pairs for ${pairList[i]} : ${my_pair}")
    }
}

/*
입력 값
4
2
3
4
5
*/