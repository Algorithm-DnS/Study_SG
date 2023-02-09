package Chap05_BFS_DFS

import java.util.*

fun main() {
    val p = readln()

    if(checkProper(p)) {
        println(p)
        return
    }
    println(recursive(p))
}

fun checkProper(w: String) : Boolean {
    val stack = Stack<Char>()

    for(i in w) {
        if(stack.isEmpty()) {
            // 스택이 빈경우 스택에 push하고 건너뛰기
            stack.push(i)
            continue
        }
        if(stack.peek() - i == -1) {
            stack.pop()
        } else {
            stack.push(i)
        }

    }

    return stack.isEmpty()
}

fun getLeastBalance(w: String) : String {
    var n = 0
    var m = 0
    if(w[0] == '(') n++ else m++
    for(i in 1 until w.length) {
        if(w[i] == '(') n++ else m++

        if(n == m) break
    }

    return w.substring(0, n+m)
}

fun recursive(w: String) : String {
//    1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
    if(w.isEmpty()) return w

//    2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
    val u = getLeastBalance(w)
    val v = if(u == w) "" else w.substring(u.length)

//    3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
//    3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
    if(checkProper(u)) return u + recursive(v)

//    4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
    val sb = StringBuilder()
    val sb2 = StringBuilder()

//    4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
//    4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
//    4-3. ')'를 다시 붙입니다.
    sb.append("(").append(recursive(v)).append(")")

//    4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
    for(i in 1 until u.length-1) {
        if(u[i] == '(') sb2.append(")")
        else sb2.append("(")
    }

//    4-5. 생성된 문자열을 반환합니다.
    sb.append(sb2.toString())

    return sb.toString()
}