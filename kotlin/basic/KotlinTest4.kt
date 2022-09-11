package com.example.lab2_1

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val N = readLine().toInt() // 일할 수 있는 날짜 ( 1이상 15 이하의 자연수 )

    var T = IntArray(N + 10) // 시간을 저장할 배열
    var P = IntArray(N + 10) // 각 날짜별 금액을 저장할 배열
    var dp = IntArray(N + 10) // 각 날짜별 최대 누적 금액을 저장할 배열

    var max = 0

    for (i in 1..N){
        var line= readLine().split(" ")
        T[i]=line[0].toInt()
        P[i]=line[1].toInt()
    }

    var j = N
    while ( j > 0 ) {
        var day = j + T[j]
        if (day <= N+1)  dp[j] = Math.max(P[j] + dp[day], dp[j+1])
        else dp[j] = dp[j+1]
        j--
    }
    max = dp[1]
    println(max)

    close()
}

/*
입력 값
10
5 10
5 9
5 8
5 7
5 6
5 10
5 9
5 8
5 7
5 6
*/