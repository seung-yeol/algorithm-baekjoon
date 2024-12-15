package solved_ac.class3

import java.io.BufferedReader
import java.util.*

/**
 * **문제**
 * - 철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다.
 * - 창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다.
 * - 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
 * - 하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다.
 * - 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다.
 * - 철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.
 * - 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라.
 * - 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
 *
 * **입력**
 * - 첫 줄에는 상자의 크기를 나타내는 두 정수 M,N이 주어진다. M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다. 단, 2 ≤ M,N ≤ 1,000 이다.
 * - 둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다.
 * - 즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다.
 * - 하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다.
 * - 정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
 * - 토마토가 하나 이상 있는 경우만 입력으로 주어진다.
 *
 * **출력**
 * - 여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다.
 * - 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
 *
 * @see <a href="https://www.acmicpc.net/problem/7576">토마토</a>
 * @see <img src="https://u.acmicpc.net/de29c64f-dee7-4fe0-afa9-afd6fc4aad3a/Screen%20Shot%202021-06-22%20at%202.41.22%20PM.png"/>
 * */
fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val (width, height) = bufferedReader.nextInts()
    val tomatoArray = Array(height) { IntArray(width) }

    val ripePositions = mutableListOf<Pair<Int, Int>>()
    repeat(height) { col ->
        bufferedReader.readLine().split(" ")
            .forEachIndexed { row, s ->
                val value = s.toInt()
                tomatoArray[col][row] = value
                if (value == 1) ripePositions.add(col to row)
            }
    }

    println(Q7576(tomatoArray).solve(ripePositions))
}

private class Q7576(private val tomatoArray: Array<IntArray>) {
    private val rowLastIndex = tomatoArray.first().lastIndex
    private val colLastIndex = tomatoArray.lastIndex

    fun solve(ripePositions: List<Pair<Int, Int>>): Int {
        var days = 0
        val queue = LinkedList<List<Pair<Int, Int>>>()
        queue.add(ripePositions)

        while (queue.isNotEmpty()) {
            val newRipePositions = mutableListOf<Pair<Int, Int>>()
            val positions = queue.pollFirst()
            positions.forEach { (col, row) -> newRipePositions.addAll(bfs(col, row)) }

            if (newRipePositions.isEmpty()) break

            queue.add(newRipePositions)
            days++
        }

        if (tomatoArray.none { it.contains(0) }) return days
        return -1
    }

    private fun bfs(col: Int, row: Int): List<Pair<Int, Int>> {
        val positions = mutableListOf<Pair<Int, Int>>()
        if (0 < row && tomatoArray[col][row - 1] == 0) {
            tomatoArray[col][row - 1] = 1
            positions.add(col to row - 1)
        }
        if (0 < col && tomatoArray[col - 1][row] == 0) {
            tomatoArray[col - 1][row] = 1
            positions.add(col - 1 to row)
        }
        if (row < rowLastIndex && tomatoArray[col][row + 1] == 0) {
            tomatoArray[col][row + 1] = 1
            positions.add(col to row + 1)
        }
        if (col < colLastIndex && tomatoArray[col + 1][row] == 0) {
            tomatoArray[col + 1][row] = 1
            positions.add(col + 1 to row)
        }

        return positions
    }
}

private fun BufferedReader.nextInts(): IntArray = readLine().split(" ").map(String::toInt).toIntArray()
