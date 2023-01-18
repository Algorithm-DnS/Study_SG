package Chap04_구현.Time

fun main(){
    val N = readln().toInt()
    var count = 0
    val totalSec = (N + 1) * 3600 // 시간은 0시 부터 시작이기 때문에 N이 아닌 N+1로 대입
    for(i in 0..totalSec) {
        if(convertToTime(i)) count++
    }

    println(count)
}
fun convertToTime(second : Int) : Boolean {
    val h = second / 3600
    val m = second % 3600 / 60
    val s = second % 3600 % 60

    for(ch in h.toString()) {
        if(ch == '3') {
            return true
        }
    }
    for(ch in m.toString()) {
        if(ch == '3') {
            return true
        }
    }
    for(ch in s.toString()) {
        if(ch == '3') {
            return true
        }
    }

    return false
}