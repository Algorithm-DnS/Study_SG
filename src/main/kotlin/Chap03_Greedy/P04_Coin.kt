package Chap03_Greedy.Coin

import java.util.*

fun main() {
    val n = readln().toInt()
    val arr = IntArray(n)
    val st = StringTokenizer(readln())
    for(i in 0 until n) {
        arr[i] = st.nextToken().toInt()
    }
    var answer = 1

    arr.sort()

    for(i in arr) {
        if(answer < i.toInt()) break
        answer += i.toInt()
    }

    println(answer)
}