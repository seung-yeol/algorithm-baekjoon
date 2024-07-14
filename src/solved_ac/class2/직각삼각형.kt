package solved_ac.class2

import java.util.*

/**
 * @see <a href="https://www.acmicpc.net/problem/4153">직각삼각형</a>
 *
 * 과거 이집트인들은 각 변들의 길이가 3, 4, 5인 삼각형이 직각 삼각형인것을 알아냈다. 주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하시오.
 * */
fun main() {
    val buffer = System.`in`.bufferedReader()
    val scanner = Scanner(buffer)
    val stringBuilder = StringBuilder()

    while (true) {
        val first = scanner.nextInt().run { this * this }.takeIf { it != 0 } ?: break
        val second = scanner.nextInt().run { this * this }
        val third = scanner.nextInt().run { this * this }

        val isTriangle = first + second + third == maxOf(first, second, third) * 2
        stringBuilder.appendLine(if (isTriangle) "right" else "wrong")
    }

    println(stringBuilder)
}