package src.solved_ac.class1

import java.util.*
import kotlin.math.max
import kotlin.math.min

/**
 * @see <a href="https://www.acmicpc.net/problem/10818">최소, 최대</a>
 *
 * N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
 *
 * 첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다.
 * 모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.
 * */
fun main() {
    val buffer = System.`in`.bufferedReader()
    val scanner = Scanner(buffer)

    var min = 1_000_000
    var max = -1_000_000
    repeat(scanner.nextInt()) {
        val input = scanner.nextInt()
        min = min(min, input)
        max = max(max, input)
    }
    println("$min $max")
}