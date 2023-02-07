package Chap05_BFS_DFS.Laboratory

fun main() {
    val (n, m) = readln().split(" ").map{it.toInt()}

    // 초기 맵 리스트
    val data = mutableListOf<MutableList<Int>>()

    // 벽을 설취한 뒤의 맵 배열
    val temp = List(n){ MutableList(m){0}}

    repeat(n) {
        val list = readln().split(" ").map{it.toInt()}.toMutableList()
        data.add(list)
    }

    // 4가지 이동 방향
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    var result = 0

    // DFS를 이용해 각 바이러스가 사방으로 퍼지도록 하기
    fun virus(x: Int, y: Int) {
        for(i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            // 상, 하, 좌, 우 중에서 바이러스가 퍼질 수 있는 경우
            if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if(temp[nx][ny] == 0) {
                    // 해당 위치에 바이러스 배치하고 다시 재귀 수행
                    temp[nx][ny] = 1
                    virus(nx, ny)
                }
            }
        }
    }

    // 맵에서 안전영역 크기 계산
    fun getScore() : Int {
        var score = 0
        for(i in 0 until n) {
            for(j in 0 until m) {
                if(temp[i][j] == 0) score++
            }
        }

        return score
    }

    // DFS를 이용해 울타리를 설치하면서, 매번 안전 영역의 크기 계산
    fun dfs(count: Int) {
        // 울타리가 3개인 경우
        if(count == 3) {
            for(i in 0 until n) {
                for(j in 0 until m) {
                    temp[i][j] = data[i][j]
                }
            }

            // 바이러스 전파 진행
            for(i in 0 until n) {
                for(j in 0 until m) {
                    if(temp[i][j] == 2) virus(i ,j)
                }
            }

            // 안전 영역의 최댓값 계산
            result = maxOf(result, getScore())
            return
        }

        // 빈 공간에 울타리 설치
        for(i in 0 until n) {
            for(j in 0 until m) {
                if(data[i][j] == 0) {
                    // 울타리 설치
                    data[i][j] = 1

                    dfs(count+1)

                    // 울타리 치우기
                    data[i][j] = 0
                }
            }
        }
    }

    dfs(0)
    println(result)
}