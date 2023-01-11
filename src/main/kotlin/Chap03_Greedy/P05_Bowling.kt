package Chap03_Greedy.Bowling

fun main() {
    val (n, m) = readln().split(" ").map{it.toInt()}
    val data = readln().split(" ").toMutableList()
    var answer = 0

    for(i in 0 until data.size-1) {
        for(j in i+1 until data.size) {
            if(data[i] != data[j]) answer++
        }
    }
    println(answer)
}