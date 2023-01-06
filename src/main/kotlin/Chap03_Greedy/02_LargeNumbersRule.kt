package Chap03_Greedy.Rule

/** 그리디 알고리즘 (탐욕법)
 * Chapter03 실전문제 큰 수의 법칙 p.92
 */
fun main() {
    // N, M, K를 공백으로 구분하여 입력받기
    var (n, m, k) = readln().split(" ").map{ it.toInt() }
    // N개의 수를 공백으로 구분하여 입력받기
    var data = readln().split(" ").map{ it.toInt() }.toMutableList()

    data.sort() // 입력받은 수들 정렬하기
    val first = data[n-1] // 가장 큰 수
    val second = data[n-2] // 두 번째로 큰 수

    var result = 0

    while(true) {
        for(i in 1..k) { // 가장 큰 수를 K번 더하기
            if(m==0) break // m이 0이라면 반복문 탈출
            result += first
            m-- // 더할 때마다 1씩 빼기
        }
        if(m==0) break // m이 0이라면 반복문 탈출
        result += second // 두 번째로 큰 수를 한 번 더하기
        m-- // 더할 때마다 1씩 빼기
    }

    println(result)
}