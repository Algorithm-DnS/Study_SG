package Chap05_BFS_DFS

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map{it.toInt()}.toIntArray() // 입력된 수 배열
    val operators = readln().split(" ").map{it.toInt()}.toIntArray() // 연산자 배열 0: 더하기, 1: 빼기, 2: 곱하기, 3: 나누기


    var max = Integer.MIN_VALUE
    var min = Integer.MAX_VALUE

    fun dfs(i: Int, num: Int) {
        // 탈출
        if(i == n) { // 모든 수를 다 돌았을 경우
            max = Math.max(max, num)
            min = Math.min(min, num)
            return
        }
        for(oper in 0..3) {
            if (operators[oper] > 0) {
                operators[oper]--
                when (oper) {
                    0 -> dfs(i + 1, num + arr[i])
                    1 -> dfs(i + 1, num - arr[i])
                    2 -> dfs(i + 1, num * arr[i])
                    3 -> dfs(i + 1, num / arr[i])
                }
                operators[oper]++
            }
        }
    }

    dfs(1, arr[0])
    println(max)
    println(min)
}
