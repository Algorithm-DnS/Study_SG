package Chap03_Greedy.Change

/** 그리디 알고리즘 (탐욕법)
 * Chapter03 예제1 거스름돈 p.87
 */
fun main() {
    var n = 1260
    var count = 0

    val arr = intArrayOf(500, 100, 50, 10)

    for(coin in arr) {
        count += n/coin
        n %= coin
    }

    println(count)
}
