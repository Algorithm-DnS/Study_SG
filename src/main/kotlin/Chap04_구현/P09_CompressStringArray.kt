package Chap04_구현.CompressStringArray

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val s = readLine()
    var result = s.length

    for(i in 1..s.length/2 + 1) {
        var compressed = ""
        var prev = s.substring(0, i)
        var count = 1
        for(j in i..s.length step i) {
            if(prev == s.substring(j, j + i + 1))
                count ++
            else {
                if(count >= 2) compressed += count.toString() + prev
                else compressed += prev
                prev = s.substring(j, j+i)
                count = 1
            }
        }
        if(count >= 2) compressed += count.toString() + prev
        else compressed += prev

        result = Math.min(result, compressed.length)
    }
}