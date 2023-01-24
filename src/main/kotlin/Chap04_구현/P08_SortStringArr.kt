package Chap04_구현.SortStringArr

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val s = readLine()
    var list = ArrayList<String>()
    var sum = 0

    for(ch in s) {
        if(ch in '0'..'9') sum += Character.getNumericValue(ch)
        else list.add(ch.toString())
    }

    list.sort()

    if(sum != 0) list.add(sum.toString())

    for(i in list)
        print(i)
}