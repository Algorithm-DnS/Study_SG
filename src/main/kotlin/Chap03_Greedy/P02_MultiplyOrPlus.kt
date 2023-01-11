package Chap03_Greedy.MOP

fun main() {
    val str = readln()
    var answer = 0
    for(s in str) {
        if(s == '0' || s == '1' || answer <= 1) {
            answer += Character.getNumericValue(s)
        } else {
            answer *= Character.getNumericValue(s)
        }
    }

    println(answer)
}