package Chap05_BFS_DFS.Factorial2Way

fun main() {
    println("반복적으로 구현 : ${factorial_iterative(5)}")
    println("재귀적으로 구현 : ${factorial_recursive(5)}")
}

fun factorial_iterative(n: Int) : Int {
    var result = 1

    // 1부터 n까지의 수를 차례대로 곱하기
    for(i in 1..n) result *= i

    return result
}

fun factorial_recursive(n: Int) : Int {
    // n이 1 이하인 경우 1을 반환
    if(n <= 1) return 1
    // n! = n * (n - 1)! 를 그대로 코드로 작성
    return n * factorial_recursive(n-1)
}