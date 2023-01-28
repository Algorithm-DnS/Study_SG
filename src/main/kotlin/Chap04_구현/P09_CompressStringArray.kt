package Chap04_구현.CompressStringArray

import java.io.BufferedReader
import java.io.InputStreamReader

class Solution {
    fun solution(s: String): Int {
        var answer = s.length
        var count = 1
        for (i in 1..s.length / 2) {
            val result = StringBuilder()
            var base = s.substring(0, i)
            var j = i
            while (j <= s.length) {

                val endIdx = Math.min(j + i, s.length)
                val compare = s.substring(j, endIdx)
                if (base == compare) {
                    count++
                } else {
                    if (count >= 2) {
                        result.append(count)
                    }
                    result.append(base)
                    base = compare
                    count = 1
                }
                j += i
            }
            result.append(base)
            answer = Math.min(answer, result.length)
        }
        return answer
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sol = Solution()
    val s = readLine()
    println(sol.solution(s))
}