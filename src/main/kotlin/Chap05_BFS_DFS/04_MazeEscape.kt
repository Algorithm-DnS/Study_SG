package Chap05_BFS_DFS.MazeEscape

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

// 상, 하, 좌, 우
val dx = arrayOf(-1, 1, 0, 0)
val dy = arrayOf(0, 0, -1, 1)

lateinit var map: Array<IntArray>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (N, M) = readLine().split(" ").map{ it.toInt() }
    map = Array(N) { IntArray(M) { 0 } }
    for(i in 0 until N) {
        val line = readLine()
        for(j in 0 until line.length) {
            // Char형을 int형으로 변환
            map[i][j] = line[j] - '0'
        }
    }

    println(bfs(0, 0, N, M))
}

fun bfs(x: Int, y: Int, N: Int, M: Int) : Int {
    val queue: Deque<Pos> = ArrayDeque()
    queue.offer(Pos(x, y))

    while(!queue.isEmpty()) {
        val (_x, _y) = queue.pollFirst()
        for(i in 0 until 4) {
            val nx = _x + dx[i]
            val ny = _y + dy[i]

            // 맵의 범위 밖으로 벗어날 경우 무시
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue
            // 벽인 경우 무시
            if(map[nx][ny] == 0) continue

            // 처음 방문일 경우에만 최단 거리 기록
            if(map[nx][ny] == 1) {
                map[nx][ny] = map[_x][_y] + 1
                queue.offer(Pos(nx, ny))
            }
        }
    }

    return map[N-1][M-1]
}

data class Pos(val x: Int, val y: Int)