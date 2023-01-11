package Chap03_Greedy.ReverseString

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val str = readLine()
    var count = 0
    var ch = str[0]
    for(i in str) {
       if(ch != i) {
           count++
           ch = i
       }
    }
    val answer = if(count%2 == 1) count/2+1 else count/2

    println(answer)
}