package Chap05_BFS_DFS

import java.util.*

fun main() {
    val (n, k) = readln().split(" ").map{it.toInt()}
    val map = mutableListOf<MutableList<Int>>()
    val virusList = mutableListOf<Virus>()

    for(i in 0 until n) {
        val list = readln().split(" ").map{it.toInt()}.toMutableList()
        map.add(list)
        for(j in 0 until n) {
            if(map[i][j] != 0) {
                virusList.add(Virus(map[i][j], 0, i, j))
            }
        }
    }

    virusList.sortBy { it.level }
    val queue: Deque<Virus> = ArrayDeque(virusList)

    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    val (s, x, y) = readln().split(" ").map{it.toInt()}

    while(queue.isNotEmpty()) {
        val (nv, ns, vx, vy) = queue.pop()
        if(s == ns) break

        for(i in 0..3) {
            val nx = dx[i] + vx
            val ny = dy[i] + vy
            if(nx in 0 until n && ny in 0 until n) {
                if(map[nx][ny] == 0) {
                    map[nx][ny] = nv
                    queue.add(Virus(nv, ns+1, nx, ny))
                }
            }
        }
    }

    println(map[x-1][y-1])
}

data class Virus(val level: Int, val time: Int, val x: Int, val y: Int)