package solved_ac.class3

import kotlin.math.max

/**
 * **문제**
 * - 수빈이는 동생과 숨바꼭질을 하고 있다.
 * - 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
 * - 수빈이는 걷거나 순간이동을 할 수 있다.
 * - 걷는다면 위치가 X일 때  1초 후에 X-1 또는 X+1로 이동하게 된다.
 * - 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
 * - 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
 *
 * **입력**
 * - 첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
 *
 * **출력**
 * - 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
 *
 * @see <a href="https://www.acmicpc.net/problem/1697">숨바꼭질</a>
 * */
fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val (n, k) = bufferedReader.readLine().split(" ").map(String::toInt)

    val question = Q1697(n, k)
    println(question.solve())
}

private class Q1697(private val n: Int, private val k: Int) {
    private val visited = BooleanArray(max(k * 2 + 1, n + 1))

    fun solve(): Int {
        visited[n] = true

        var queue = listOf(n)
        var duration = 0

        while (true) {
            if (queue.contains(k)) return duration

            duration++
            queue = next(queue, k)
        }
    }

    private fun next(list: List<Int>, k: Int): List<Int> {
        val nexts = mutableListOf<Int>()
        for (i in list) {
            val news = when {
                k < i -> listOf(i - 1)
                i == 0 -> listOf(1)
                else -> listOf(i - 1, i + 1, i * 2)
            }

            for (new in news) {
                if (visited[new]) continue

                visited[new] = true
                nexts.add(new)
            }
        }

        return nexts
    }
}