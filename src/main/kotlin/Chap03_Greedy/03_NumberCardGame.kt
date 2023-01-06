package Chap03_Greedy.Game
/** 그리디 알고리즘 (탐욕법)
 * Chapter03 실전문제 숫자 카드 게임 p.96
 */
import java.util.*

fun main() {
    // N, M을 공백으로 구분하여 입력받기
    val (n, m) = readln().split(" ").map{it.toInt()}

    var result = 0
    // 한 줄씩 입력받아 확인
    for(i in 1..n) {
        val data = readln().split(" ").map {it.toInt()}.toList()
        // 현재 줄에서 '가장 작은 수' 찾기
        val min_value = Collections.min(data)
        // '가장 작은 수'들 중에서 가장 큰 수 찾기
        result = result.coerceAtLeast(min_value) // Math.max와 같음
    }

    println(result)
}