package Chap05_BFS_DFS.QueueEx

import java.util.*

fun main() {
    var queue : Queue<Int> = LinkedList() // 큐로 선언하고 LinkedList 로 할당

    queue.add(5) // 객체를 큐에 추가 (큐가 가득찬 상태이면 illegalStateException 발생)
    queue.offer(2) // 객체를 큐에 추가 (큐가 가득찬 상태이면 false 반환)
    queue.offer(3)
    queue.offer(7)

    println(queue.element()) // 맨 앞 객체 리턴 (큐가 비어있는 상태이면 NoSuchElementException 발생)
    println(queue.elementAt(1)) // 인덱스 값의 객체 리턴
    println(queue.peek()) // 맨 앞 객체 리턴 (큐가 비어있는 상태이면 false 반환)

    queue.remove() // 삭제하면서 객체 반환 (큐가 비어있는 상태이면 NoSuchElementException 발생)
    var tmp = queue.poll()  // 삭제하면서 객체 반환 (큐가 비어있는 상태이면 false 반환)
    println(queue)
    println("두번째 삭제한 객체 : $tmp")
}