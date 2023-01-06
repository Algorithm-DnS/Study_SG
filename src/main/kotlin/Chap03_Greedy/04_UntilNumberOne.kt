package Chap03_Greedy.NumberOne
/** 그리디 알고리즘 (탐욕법)
 * Chapter03 실전문제 1이 될 때까지 p.99
 */
fun main() {
    var (n, k) = readln().split(" ").map{it.toInt()}
    var result = 0

    // N이 K 이상이라면 K로 계속 나누기
    while(n>=k) {
        // N이 K로 나누어 떨어지지 않는다면 N에서 1씩 빼기
        while(n%k != 0) {
            n--
            result++
        }
        // K로 나누기
        n /= k
        result++
    }

    //마지막으로 남은 수에 대하여 1씩 빼기
    while(n>1) {
        n--
        result++
    }

    println(result)
}