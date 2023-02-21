package Chap05_BFS_DFS

import java.util.*

val map = mutableListOf<MutableList<String>>()
val dx = arrayOf(-1, 1, 0, 0) // 상하좌우
val dy = arrayOf(0, 0, -1, 1)
fun main() {
    val n = readln().toInt() // n * n 사이즈의 맵

    val queue: Queue<Teacher> = ArrayDeque() // 선생님 위치를 보관할 큐

    for (i in 0 until n) {
        map.add(readln().split(" ").toMutableList())
        for (j in 0 until n) {
            // 선생님의 위치를 기록
            if (map[i][j] == "T") queue.add(Teacher(i, j))
        }
    }

    var wall = 3 // 벽 3개

    while (queue.isNotEmpty()) {
        val t = queue.poll() // 선생님 위치정보 큐에서 하나씩 꺼내기
        for (i in 0..3) {
            val findStudent = watch(t.x, t.y, i) // 학생 발견 여부, 발견시 학생위치, 미발견시 -1 반환
            if (findStudent != -1) { // 학생이 발견됐을 경우
                if (wall <= 0) { // 설치할 수 있는 벽이 없을 경우 종료
                    println("NO")
                    return
                }
                when (i) {
                    0 -> {
                        if (t.x == findStudent + 1) { // 선생님이 학생의 바로 밑에 있을 경우 NO 출력 후 종료 (벽을 세울 수 없기 때문)
                            println("NO")
                            return
                        }
                        map[findStudent + 1][t.y] = "O"
                        wall--
                    }
                    1 -> {
                        if (t.x == findStudent - 1) { // 선생님이 학생의 바로 위에 있을 경우 NO 출력 후 종료 (벽을 세울 수 없기 때문)
                            println("NO")
                            return
                        }
                        map[findStudent - 1][t.y] = "O"
                        wall--
                    }
                    2 -> {
                        if (t.y == findStudent + 1) { // 선생님이 학생의 바로 우측에 있을 경우 NO 출력 후 종료 (벽을 세울 수 없기 때문)
                            println("NO")
                            return
                        }
                        map[t.x][findStudent + 1] = "O"
                        wall--
                    }
                    3 -> {
                        if (t.y == findStudent - 1) { // 선생님이 학생의 바로 우측에 있을 경우 NO 출력 후 종료 (벽을 세울 수 없기 때문)
                            println("NO")
                            return
                        }
                        map[t.x][findStudent - 1] = "O"
                        wall--
                    }
                }
            }
        }
    }
    println("YES")
}

// 특정 방향으로 학생이 있는지 판별하는 함수, 학생 있음 : 학생의 위치값, 학생 없음 : -1 반환
fun watch(x: Int, y: Int, direction: Int): Int {
    var _x = x + dx[direction]
    var _y = y + dy[direction]
    val n = map.size
    when (direction) {
        0 -> { // 위쪽 방향 감시
            while (_x >= 0) { // 맵의 끝까지 반복
                if (map[_x][y] == "S") return _x // 학생이 있으면 false 반환
                if (map[_x][y] == "O") return -1 // 벽이 있으면 true 반환
                _x--
            }
        }
        1 -> { // 아래쪽 방향 감시
            while (_x < n) { // 맵의 끝까지 반복
                if (map[_x][y] == "S") return _x // 학생이 있으면 false 반환
                if (map[_x][y] == "O") return -1 // 벽이 있으면 true 반환
                _x++
            }
        }
        2 -> { // 왼쪽 방향 감시
            while (_y >= 0) { // 맵의 끝까지 반복
                if (map[x][_y] == "S") return _y // 학생이 있으면 false 반환
                if (map[x][_y] == "O") return -1 // 벽이 있으면 true 반환
                _y--
            }
        }
        3 -> { // 오른쪽 방향 감시
            while (_y < n) { // 맵의 끝까지 반복
                if (map[x][_y] == "S") return _y // 학생이 있으면 false 반환
                if (map[x][_y] == "O") return -1 // 벽이 있으면 true 반환
                _y++
            }
        }
    }
    return -1
}

data class Teacher(val x: Int, val y: Int)