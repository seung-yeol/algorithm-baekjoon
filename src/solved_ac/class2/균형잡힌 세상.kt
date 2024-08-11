package solved_ac.class2

import java.util.*

/**
 * @see <a href="https://www.acmicpc.net/problem/4949">균형잡힌 세상</a>
 *
 * 어떤 문자열이 주어졌을 때, 괄호들의 균형이 잘 맞춰져 있는지 판단하는 프로그램을 짜는 것이다.
 * 문자열에 포함되는 괄호는 소괄호("()") 와 대괄호("[]")로 2종류이고, 문자열이 균형을 이루는 조건은 아래와 같다.
 * 1. 모든 왼쪽 소괄호("(")는 오른쪽 소괄호(")")와만 짝을 이뤄야 한다.
 * 2. 모든 왼쪽 대괄호("[")는 오른쪽 대괄호("]")와만 짝을 이뤄야 한다.
 * 3. 모든 오른쪽 괄호들은 자신과 짝을 이룰 수 있는 왼쪽 괄호가 존재한다.
 * 4. 모든 괄호들의 짝은 1:1 매칭만 가능하다. 즉, 괄호 하나가 둘 이상의 괄호와 짝지어지지 않는다.
 * 5. 짝을 이루는 두 괄호가 있을 때, 그 사이에 있는 문자열도 균형이 잡혀야 한다.
 *
 * 각 문자열은 마지막 글자를 제외하고 영문 알파벳, 공백, 소괄호("( )"), 대괄호("[ ]")로 이루어져 있으며,
 * 온점(".")으로 끝나고, 길이는 100글자보다 작거나 같다.
 *
 * 입력의 종료조건으로 맨 마지막에 온점 하나(".")가 들어온다.
 *
 * 각 줄마다 해당 문자열이 균형을 이루고 있으면 "yes"를, 아니면 "no"를 출력한다.
 * */
fun main() {
    val sb = StringBuilder()
    top@ while (true) {
        val stack = Stack<Int>()
        val string = readln()

        if (string == ".") break

        for (c in string) {
            when (c) {
                '(' -> stack.push(0)
                '[' -> stack.push(1)
                ')' -> {
                    if (stack.isEmpty() || stack.pop() != 0) {
                        sb.appendLine("no")
                        continue@top
                    }
                }

                ']' -> {
                    if (stack.isEmpty() || stack.pop() != 1) {
                        sb.appendLine("no")
                        continue@top
                    }
                }
            }
        }

        sb.appendLine(if (stack.isEmpty()) "yes" else "no")
    }

    println(sb)
}
