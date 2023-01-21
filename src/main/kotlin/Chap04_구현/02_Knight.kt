package Chap04_구현.Knight

fun main() {
    val input = readln()
    val row = Character.getNumericValue(input[1])
    val col = input[0] - 'a' + 1

    val step_types = arrayOf(arrayOf(-2, -1), arrayOf(-1, -2), arrayOf(1, -2),
        arrayOf(2, -1), arrayOf(2, 1), arrayOf(1, 2), arrayOf(-1, 2), arrayOf(-2, 1))

    var count = 0

    for(step in step_types) {

    }
}