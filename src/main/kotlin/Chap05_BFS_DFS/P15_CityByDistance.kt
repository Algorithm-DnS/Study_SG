package Chap05_BFS_DFS.CityByDistance

import java.util.*

// 간선의 비용이 모두 동일하기 때문에 BFS 활용
fun main() {
    // n : 도시의 개수, m : 도로의 개수, k : 거리 정보, x : 출발 도시 번호
    val (n, m, k, x) = readln().split(" ").map { it.toInt() }

    // 노드 연결 정보
    // var graph = Array(n+1){ mutableListOf<Pair<Int, Int>>()}
    val graph = Array(n + 1) { mutableListOf<Int>() }

    // 최단 거리 테이블
    val distance = (0..n).map { -1 }.toMutableList() // n+1개가 -1로 초기화된 리스트
    // 출발 도시까지의 거리는 0으로 설정
    distance[x] = 0

    // m번 반복
    repeat(m) {
        // 모든 도로 정보 입력받기
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b)
    }

    // bfs 수행
    val queue: Deque<Int> = ArrayDeque()
    queue.offer(x)
    while (queue.isNotEmpty()) {
        val now = queue.pollFirst()
        // 현재 도시에서 이동할 수 있는 모든 도시를 확인
        for (next_node in graph[now]) {
            // 아직 방문하지 않은 도시라면
            if (distance[next_node] == -1) {
                // 최단 거리 갱신
                distance[next_node] = distance[now] + 1
                queue.offer(next_node)
            }
        }
    }

    var check = false
    for (i in 1..n) {
        if (distance[i] == k) {
            println(i)
            check = true
        }
    }

    if (check.not()) println(-1)
}