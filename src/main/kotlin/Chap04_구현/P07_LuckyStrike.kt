package Chap04_구현.LuckyStrike

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val N = readLine()
    var n1 = 0
    var n2 = 0
    for(i in N.indices) {
        if(i < N.length/2) n1 += Character.getNumericValue(N[i])
        else  n2 += Character.getNumericValue(N[i])
    }

    val result = if(n1 == n2) "LUCKY" else "READY"

    println(result)
}