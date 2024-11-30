package solved_ac.class3

import kotlin.math.abs
import kotlin.math.min

/**
 * **문제**
 * - 1 0 1 1 1 1
 * - 1 0 1 0 1 0
 * - 1 0 1 0 1 1
 * - 1 1 1 0 1 1
 * ---
 * - 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다.
 * - 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
 * - 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
 * - 위의 예에서는 15칸을 지나야 (N, M)의 위치로  이동할 수 있다.
 * - 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
 *
 * **입력**
 * - 첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다.
 * - 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
 *
 * **출력**
 * - 첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
 *
 * @see <a href="https://www.acmicpc.net/problem/">2178</a>
 * */
fun main() {
    val (height, width) = readln().split(" ").map(String::toInt)
    val maze = Array(height) { IntArray(width) }

    for (column in 0 until height) {
        for ((row, i) in readln().toCharArray().map(Char::digitToInt).withIndex()) {
            maze[column][row] = if (i == 1) Int.MAX_VALUE else -1
        }
    }

    println(Q2178().solve(maze))
}

class Q2178 {
    private var answer = Int.MAX_VALUE

    fun solve(maze: Array<IntArray>): Int {
        maze.dfs(column = 0, row = 0, count = 0)
        return answer
    }

    private fun Array<IntArray>.dfs(column: Int, row: Int, count: Int) {
        if (isBlocked(column, row)) return

        val visitCount = this[column][row]
        if (visitCount <= count) return
        this[column][row] = count

        val nextCount = count + 1
        val columnLastIndex = lastIndex
        val rowLastIndex = first().lastIndex
        if (column == columnLastIndex && row == rowLastIndex) {
            answer = min(answer, nextCount)
            return
        }

        for (nextColumn in column - 1..column + 1) {
            for (nextRow in row - 1..row + 1) {
                val isValid = abs(nextColumn + nextRow - column - row) == 1 &&
                        nextColumn in 0..columnLastIndex &&
                        nextRow in 0..rowLastIndex
                if (!isValid) continue

                dfs(column = nextColumn, row = nextRow, count = nextCount)
            }
        }
    }

    private fun Array<IntArray>.isBlocked(column: Int, row: Int): Boolean = this[column][row] == -1
}
