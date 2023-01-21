package Chap04_구현.GameDevelop

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(" ").map{it.toInt()}
    var (x, y, d) = readLine().split(" ").map{it.toInt()}

    val arr = Array(N) {
        IntArray(M)
    }
    val dx = arrayOf(-1, 0, 1, 0)
    val dy = arrayOf(0, 1, 0, -1)

    var turnCount = 0
    var count = 1 // 3번 매뉴얼에서 뒤로가는 횟수를 포함하여 카운트를 미리 1로 설정

    fun turnLeft() {
        d--
        if(d == -1) d = 3
    }

    for(i in 0 until N) {
        val st = StringTokenizer(readLine())
        for(j in 0 until M) {
            arr[i][j] = st.nextToken().toInt()
        }
    }

    while(true) {
        turnLeft()
        var nx = x + dx[d]
        var ny = y + dy[d]

        // 회전한 뒤 정면에 가보지 않은 곳이 존재한다면
        if(arr[nx][ny] == 0) {
            arr[nx][ny] = 1 // 왔단 곳을 다시 방문할 수 없도록 이동한 곳을 바다로 표시
            x = nx
            y = ny
            count++
            turnCount = 0
        } else turnCount++

        if(turnCount == 4) {
            nx = x - dx[d]
            ny = y - dy[d]
            if(arr[nx][ny] == 1) {
                break
            }
            turnCount = 0
        }
    }

    println(count)
}