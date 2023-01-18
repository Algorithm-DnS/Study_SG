package Chap04_구현.UDLR
/** 구현
 * Chapter04 예제 상하좌우 p.110
 */
fun main() {
    val N = readln().toInt()
    var x = 1
    var y = 1

    var list = readln().split(" ").toList()
    for(way in list) {
        when(way) {
            "U" -> {
                if(x <= 1) continue
                x--
            }
            "D" -> {
                if(x >= N) continue
                x++
            }
            "L" -> {
                if(y <= 1) continue
                y--
            }
            "R" -> {
                if(y >= N) continue
                y++
            }
        }
    }

    println("$x $y")
}