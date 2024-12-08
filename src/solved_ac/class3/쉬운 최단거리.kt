package solved_ac.class3

import java.io.BufferedReader
import java.util.*

/**
 * **문제**
 * - 지도가 주어지면 모든 지점에 대해서 목표지점까지의 거리를 구하여라.
 * - 문제를 쉽게 만들기 위해 오직 가로와 세로로만 움직일 수 있다고 하자.
 *
 * **입력**
 * - 지도의 크기 n과 m이 주어진다.
 * - n은 세로의 크기, m은 가로의 크기다.(2 ≤ n ≤ 1000, 2 ≤ m ≤ 1000)
 * - 다음 n개의 줄에 m개의 숫자가 주어진다.
 * - 0은 갈 수 없는 땅이고 1은 갈 수 있는 땅, 2는 목표지점이다. 입력에서 2는 단 한개이다.
 *
 * **출력**
 * - 각 지점에서 목표지점까지의 거리를 출력한다.
 * - 원래 갈 수 없는 땅인 위치는 0을 출력하고, 원래 갈 수 있는 땅인 부분 중에서 도달할 수 없는 위치는 -1을 출력한다.
 *
 * @see <a href="https://www.acmicpc.net/problem/14940">쉬운 최단거리</a>
 * */
fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val (height, width) = bufferedReader.nextInts()
    val matrix = Array(height) { IntArray(width) }
    var startPosition = 0 to 0

    repeat(height) { y ->
        for ((x, i) in bufferedReader.nextInts().withIndex()) {
            if (i == 2) {
                startPosition = y to x
                continue
            }
            matrix[y][x] = i
        }
    }

    val answer = Q14940().solve(matrix, startPosition)
    println(answer)
}

private class Q14940 {
    fun solve(matrix: Array<IntArray>, startPosition: Pair<Int, Int>): String {
        val queue = LinkedList<Pair<Int, Int>>().apply { add(startPosition) }

        while (queue.isNotEmpty()) {
            val (y, x) = queue.pollFirst()
            queue.addAll(matrix.bfs(y, x))
        }

        // 거리를 음수로 넣어놔서 양수로 변환.
        return matrix.joinToString("\n") { it.joinToString(" ") { invertedDistance -> "${-invertedDistance}" } }
    }

    // 거리를 음수로 변환하여 matrix에 넣어줌.
    // 갈 수 있는 모든 위치에 도달했을 때, this[y][x]가 1인 값들은 도달하지 못한 위치.
    private fun Array<IntArray>.bfs(y: Int, x: Int): List<Pair<Int, Int>> {
        val nexts = mutableListOf<Pair<Int, Int>>()
        var acc = this[y][x]
        acc = if (acc == 1) -2 else acc - 1

        if (0 <= x - 1 && (this[y][x - 1] == 1 || this[y][x - 1] < acc)) {
            this[y][x - 1] = acc
            nexts.add(y to x - 1)
        }
        if (0 <= y - 1 && (this[y - 1][x] == 1 || this[y - 1][x] < acc)) {
            this[y - 1][x] = acc
            nexts.add(y - 1 to x)
        }
        if (x + 1 <= first().lastIndex && (this[y][x + 1] == 1 || this[y][x + 1] < acc)) {
            this[y][x + 1] = acc
            nexts.add(y to x + 1)
        }
        if (y + 1 <= lastIndex && (this[y + 1][x] == 1 || this[y + 1][x] < acc)) {
            this[y + 1][x] = acc
            nexts.add(y + 1 to x)
        }

        return nexts
    }

}

private fun BufferedReader.nextInts(): IntArray = readLine().split(" ").map(String::toInt).toIntArray()
