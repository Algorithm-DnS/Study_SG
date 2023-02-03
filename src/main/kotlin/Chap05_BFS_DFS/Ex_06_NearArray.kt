package Chap05_BFS_DFS.NearArray

const val INF = 999999999 // 무한의 비용 선언

fun main() {
    val graph = arrayOf(arrayOf(0, 7, 5), arrayOf(7, 0, INF), arrayOf(5, INF, 0))

    println(graph.contentDeepToString())
}