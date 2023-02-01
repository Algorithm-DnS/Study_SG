package Chap04_구현.LockKey

class Solution {
    lateinit var key: Array<IntArray>
    fun solution(_key: Array<IntArray>, lock: Array<IntArray>) : Boolean {
        val size = lock.size * 3
        val originalSize = lock.size
        val lockExtand = Array(size){IntArray(size) { 0 }} // 자물쇠 영역을 3배 확장

        key = _key

        for(i in 0 until originalSize) {
            for(j in 0 until originalSize) {
                lockExtand[i + originalSize][j + originalSize] = lock[i][j] // 중앙에 기존 자물쇠 대입
            }
        }

        // 확장된 자물쇠 영역에서 왼쪽 상단부터 순서대로 키 대입
        // 완전탐색으로 한번의 루틴이 종료될 때 마다 키를 회전해야 하기 때문에 4번 수행
        for(n in 0 until 4) {
            // 원래 size의 2배까지만 하는 이유 = 2배 이상의 범위부터는 중앙의 기존 자물쇠 영역에서 우측으로 벗어나기 때문
            for(x in 0 until originalSize*2) {
                for(y in 0 until originalSize*2) {
                    for(i in 0 until key.size) {
                        for(j in 0 until key.size) {
                            // 확장된 자물쇠 영역에 키값 추가
                            lockExtand[x+i][y+j] += key[i][j]
                        }
                    }
                    if(checkLock(lockExtand)) return true

                    //다음 순회를 위해 더해줬던 열쇠값을 빼준다
                    for (i in 0 until key.size) {
                        for (j in 0 until key.size) {
                            lockExtand[x + i][y + j] -= key[i][j]
                        }
                    }
                }
            }

            rotateKey()
        }
        return false
    }

    fun checkLock(_extendLock: Array<IntArray>): Boolean {
        var size = _extendLock.size / 3
        for (x in size until size * 2) {
            for (y in size until size * 2) {
                //한 부분이라도 1이(돌기) 가 아니면 false
                if (_extendLock[x][y] != 1) return false
            }
        }
        return true
    }

    fun rotateKey() {
        val n = key.size
        val result = Array(n){IntArray(n) { 0 }}

        for(i in 0 until n) {
            for(j in 0 until n) {
                result[j][n-i-1] = key[i][j]
            }
        }
        key = result
    }
}

fun main() {
    val key = arrayOf(intArrayOf(0, 0, 0), intArrayOf(1, 0, 0), intArrayOf(0, 1, 1))
    val lock = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 0), intArrayOf(1, 0, 1))

    val sol = Solution()
    println(sol.solution(key, lock))
}