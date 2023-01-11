package Chap03_Greedy.Guild

import java.util.*

fun main() {
    val n = readln().toInt()
    val arr = IntArray(n)
    val st = StringTokenizer(readln())
    for(i in 0 until n) {
        arr[i] = st.nextToken().toInt()
    }

    arr.sort() // 공포도 오름차순으로 정렬
    // {1, 2, 2, 2, 3}

    var count = 0
    var answer = 0
    for(i in arr) {
        // 정렬된 배열을 한개씩 순회
        count++
        if(count >= i) {
            answer = count
            count = 0
        }
    }

    println(answer)
}