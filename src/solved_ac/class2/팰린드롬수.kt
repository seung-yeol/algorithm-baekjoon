package src.solved_ac.class2

import java.util.*

/**
 * @see <a href="https://www.acmicpc.net/problem/1259">팰린드롬수</a>
 *
 * 수의 숫자들을 뒤에서부터 읽어도 같다면 그 수는 팰린드롬수다. 121, 12421 등은 팰린드롬수다.
 * 123, 1231은 뒤에서부터 읽으면 다르므로 팰린드롬수가 아니다.
 * 또한 10도 팰린드롬수가 아닌데, 앞에 무의미한 0이 올 수 있다면 010이 되어 팰린드롬수로 취급할 수도 있지만, 특별히 이번 문제에서는 무의미한 0이 앞에 올 수 없다고 하자.
 *
 * 입력은 여러 개의 테스트 케이스로 이루어져 있으며, 각 줄마다 1 이상 99999 이하의 정수가 주어진다.
 * 입력의 마지막 줄에는 0이 주어지며, 이 줄은 문제에 포함되지 않는다.
 * */
fun main() {
    val buffer = System.`in`.bufferedReader()
    val scanner = Scanner(buffer)
    val stringBuilder = StringBuilder()

    while (true) {
        val number = scanner.next().takeIf { it != "0" } ?: break
        val isPalindrome = (0 until number.length / 2)
            .all { number[it] == number[number.length - it - 1] }

        stringBuilder.appendLine(if (isPalindrome) "yes" else "no")
    }

    println(stringBuilder)
}