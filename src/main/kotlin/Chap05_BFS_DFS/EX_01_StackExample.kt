package Chap05_BFS_DFS.StackEx

import java.util.*

fun main() {
    var stack = Stack<Int>()

    stack.push(5)
    stack.push(2)
    stack.push(3)
    stack.push(7)
    stack.pop()
    stack.push(1)
    stack.push(4)
    stack.pop()

    print(stack) // 최하단 원소부터 출력
}