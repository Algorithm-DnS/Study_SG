package Chap05_BFS_DFS.Recursive

fun main() {
    recursive()
}

fun recursive(count: Int = 1) {
    println("재귀 함수를 호출합니다. $count")
    recursive(count + 1)
}