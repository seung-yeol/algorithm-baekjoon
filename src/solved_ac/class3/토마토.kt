package solved_ac.class3

import java.io.BufferedReader
import java.util.*

/**
 * **문제**
 * - 토마토는 아래의 그림과 같이 격자모양 상자의 칸에 하나씩 넣은 다음, 상자들을 수직으로 쌓아 올려서 창고에 보관한다.
 * - 창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다.
 * - 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
 * - 하나의 토마토에 인접한 곳은 위, 아래, 왼쪽, 오른쪽, 앞, 뒤 여섯 방향에 있는 토마토를 의미한다.
 * - 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다.
 * - 철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지 그 최소 일수를 알고 싶어 한다.
 * - 토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때, 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라.
 * - 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
 *
 *
 * **입력**
 * - 첫 줄에는 상자의 크기를 나타내는 두 정수 M,N과 쌓아올려지는 상자의 수를 나타내는 H가 주어진다.
 * - M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다.
 * - 단, 2 ≤ M ≤ 100, 2 ≤ N ≤ 100, 1 ≤ H ≤ 100 이다.
 * - 둘째 줄부터는 가장 밑의 상자부터 가장 위의 상자까지에 저장된 토마토들의 정보가 주어진다.
 * - 즉, 둘째 줄부터 N개의 줄에는 하나의 상자에 담긴 토마토의 정보가 주어진다.
 * - 각 줄에는 상자 가로줄에 들어있는 토마토들의 상태가 M개의 정수로 주어진다.
 * - 정수 1은 익은 토마토, 정수 0 은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
 * - 이러한 N개의 줄이 H번 반복하여 주어진다.
 * - 토마토가 하나 이상 있는 경우만 입력으로 주어진다.
 *
 * **출력**
 * - 여러분은 토마토가 모두 익을 때까지 최소 며칠이 걸리는지를 계산해서 출력해야 한다.
 * - 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
 *
 * @see <a href="https://www.acmicpc.net/problem/7569">토마토</a>
 * @see <img src="https://u.acmicpc.net/c3f3343d-c291-40a9-9fe3-59f792a8cae9/Screen%20Shot%202021-06-22%20at%202.49.11%20PM.png"/>
 * */
fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val (m, n, h) = bufferedReader.nextInts()
    val boxes = Array(h) { Array(n) { IntArray(m) } }

    repeat(h) { hIndex ->
        repeat(n) { nIndex ->
            bufferedReader.nextInts().forEachIndexed { mIndex, value ->
                boxes[hIndex][nIndex][mIndex] = value
            }
        }
    }

    println(Q7569(boxes).solve())
}

class Q7569(private val boxes: Array<Array<IntArray>>) {
    fun solve(): Int {
        var days = 0
        val queue = LinkedList<Set<Coord>>()
        check()?.let { queue.add(it) } ?: return 0

        while (queue.isNotEmpty()) {
            val today = queue.pollFirst()
            val tomorrow = mutableSetOf<Coord>()
            today.forEach { (h, n, m) ->
                val nexts = spread(h, n, m)
                if (nexts.isNotEmpty()) tomorrow.addAll(nexts)
            }

            if (tomorrow.isNotEmpty()) {
                days++
                queue.add(tomorrow)
            }
        }

        val isSuccess = boxes.all { box -> box.all { tomatos -> tomatos.none { it == 0 } } }
        return if (isSuccess) days else -1
    }

    private fun check(): Set<Coord>? {
        val init = mutableSetOf<Coord>()
        var isAll = true

        boxes.forEachIndexed { h, box ->
            box.forEachIndexed { n, tomatos ->
                tomatos.forEachIndexed { m, tomato ->
                    if (tomato == 0) isAll = false
                    if (tomato == 1) init.add(Coord(h, n, m))
                }
            }
        }

        return if (isAll) null else init
    }

    private fun spread(h: Int, n: Int, m: Int): List<Coord> {
        val changed = mutableListOf<Coord>()
        val hDiff = listOf(-1, 1, 0, 0, 0, 0)
        val nDiff = listOf(0, 0, -1, 1, 0, 0)
        val mDiff = listOf(0, 0, 0, 0, -1, 1)

        repeat(6) {
            val nextH = hDiff[it] + h
            val nextN = nDiff[it] + n
            val nextM = mDiff[it] + m
            if (nextH < 0 || boxes.lastIndex < nextH) return@repeat
            if (nextN < 0 || boxes[nextH].lastIndex < nextN) return@repeat
            if (nextM < 0 || boxes[nextH][nextN].lastIndex < nextM) return@repeat

            val nextTomato = boxes[nextH][nextN][nextM]
            if (nextTomato == 0) {
                changed.add(Coord(nextH, nextN, nextM))
                boxes[nextH][nextN][nextM] = 1
            }
        }

        return changed
    }

    private data class Coord(val h: Int, val n: Int, val m: Int)
}

private fun BufferedReader.nextInts(): List<Int> = readLine().split(" ").map(String::toInt)
