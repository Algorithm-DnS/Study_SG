package Chap04_구현.Snake

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

// 생각해 볼 순서
// 1. 전방으로 몸 길이를 늘린다.
// 2. 머리가 만약 벽이나 몸에 닿을 경우 종료하고 시간을 출력한다
// 3. 머리가 있는 곳에 사과가 있다면 몸길이를 늘린다.(꼬리를 이동하지 않는다.)
// 4. 만약 시간이 X초면 머리를 회전한다.

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt() // N x N 크기의 맵
    val K = readLine().toInt() // K개의 사과
    val map = Array(N) { IntArray(N) }
    val command: Queue<Command> = LinkedList() // 회전 명령을 담을 큐
    val snake = ArrayDeque<Snake>() // 뱀의 좌표를 담을 큐
    var count = 0

    // 0: 동, 1: 남, 2: 서, 3: 북
    var dir = 0
    val dx = arrayOf(0, 1, 0, -1)
    val dy = arrayOf(1, 0, -1, 0)

    // 사과 배치
    for (i in 0 until K) {
        // 사과의 위치를 좌표평면상으로 옮기기 위해 입력값의 -1
        val (x, y) = readLine().split(" ").map { it.toInt() - 1 }
        map[x][y] = 1
    }

    // 뱀의 방향 회전 정보 추가
    val L = readLine().toInt()
    for(i in 0 until L) {
        val st = StringTokenizer(readLine())
        command.add(Command(st.nextToken().toInt(), st.nextToken()))
    }


    // 초기 위치 0, 0 추가
    snake.add(Snake(0, 0))
    map[0][0] = -1
    while(true) {
        count++

        val nx = snake.peekFirst().x + dx[dir]
        val ny = snake.peekFirst().y + dy[dir]
        snake.addFirst(Snake(nx, ny))

        // 벽이나 몸에 부딪히면 게임 종료
        if(snake.peekFirst().x < 0 || snake.peekFirst().y < 0
            || snake.peekFirst().x >= N || snake.peekFirst().y >= N
            || map[nx][ny] == -1) break


        // 사과가 있으면 몸길이 그대로, 없으면 꼬리 제거
        if(map[nx][ny] != 1) {
            val removeSnake = snake.pollLast()
            map[removeSnake.x][removeSnake.y] = 0
        }
        map[nx][ny] = -1


        // 머리 회전 검사
        if(!command.isEmpty() && command.peek().time == count) {
            val mCommand = command.poll()

            // 머리가 오른쪽으로 회전할 때에는 (현재 방향 + 1) %4 로 다음 방향을 나타낼 수 있다.
            // 머리가 왼쪽으로 회전할 때에는 (현재 방향 - 1) %4 이다. 하지만, 현재방향이 0인 경우, -1%4가 되어 값이 이상해짐.
            // 이 때에는, mod연산자의 특징을 이용해서 (현재방향 + 4 - 1) %4 로 나타낼 수 있다.
            // 즉, 시간 마다 오른쪽(+1)로 이동하는지, 왼쪽(-1)로 이동하는지 배열에 담아두고,
            // 다음 방향 = (4 + 현재 방향 - 이동방향) %4 를 이용하면 다음에 머리가 어디로 이동해야할지 쉽게 구할 수 있다
            when(mCommand.c) {
                "L" -> dir = (4 + dir - 1) % 4
                "D" -> dir = (4 + dir + 1) % 4
            }
        }
    }

    println(count)
}

data class Command(val time: Int, val c: String)
data class Snake(val x: Int, val y: Int)
