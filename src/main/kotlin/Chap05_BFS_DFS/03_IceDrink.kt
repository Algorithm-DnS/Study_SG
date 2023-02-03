package Chap05_BFS_DFS.IceDrink

import java.io.*
import java.util.*


class Q1_Freeze_Drinks {
    var n = 0
    var m = 0
    lateinit var frame: Array<IntArray>
    fun solution(): Int {
        var result = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (frame[i][j] == 0) {
                    dfs(i, j)
                    result += 1
                }
            }
        }
        return result
    }

    fun dfs(x: Int, y: Int) {
        // 범위를 벗어나면 즉시 종료
        if (x < 0 || y < 0 || x >= n || y >= m) return else if (frame[x][y] == 0) {
            // 해당 노드 방문 처리
            frame[x][y] = 1

            // 상, 하, 좌, 우의 위치도 모두 재귀적으로 호출
            dfs(x - 1, y)
            dfs(x, y - 1)
            dfs(x + 1, y)
            dfs(x, y + 1)
        }
    }

    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())
        n = st.nextToken().toInt()
        m = st.nextToken().toInt()
        frame = Array(n) { IntArray(m) }
        for (i in 0 until n) {
            val str = br.readLine()
            for (j in 0 until m) {
                frame[i][j] = str[j].code - '0'.code
            }
        }
        println(solution())
    }
}