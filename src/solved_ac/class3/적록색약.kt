package solved_ac.class3

/**
 * **문제**
 * - 크기가 N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림이 있다.
 * - 그림은 몇 개의 구역으로 나뉘어져 있는데, 구역은 같은 색으로 이루어져 있다.
 * - 또, 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다. (색상의 차이를 거의 느끼지 못하는 경우도 같은 색상이라 한다)
 *
 * - 예를 들어, 그림이 아래와 같은 경우에
 *     + RRRBB
 *     + GGBBB
 *     + BBBRR
 *     + BBRRR
 *     + RRRRR
 *
 * - 적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다.
 * - (빨강 2, 파랑 1, 초록 1) 하지만, 적록색약인 사람은 구역을 3개 볼 수 있다. (빨강-초록 2, 파랑 1)
 *
 * 그림이 입력으로 주어졌을 때, 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성하시오.
 *
 * **입력**
 * - 첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100)
 * - 둘째 줄부터 N개 줄에는 그림이 주어진다.
 *
 * **출력**
 * - 적록색약이 아닌 사람이 봤을 때의 구역의 개수와 적록색약인 사람이 봤을 때의 구역의 수를 공백으로 구분해 출력한다.
 *
 * @see <a href="https://www.acmicpc.net/problem/10026">적록색약</a>
 * */
fun main() {
    val lines = readln().toInt()

    val (normal, blindness) = Q10026(lines).solve()
    println("$normal $blindness")
}

class Q10026(lines: Int) {
    private val cells = Array(lines) { "" }
    private val normalVisited = Array(lines) { Array(lines) { false } }
    private var normalLastId = 0

    private val blindVisited = Array(lines) { Array(lines) { false } }
    private var blindLastId = 0

    init {
        repeat(lines) { cells[it] = readln() }
    }

    fun solve(): Pair<Int, Int> {
        for ((y, line) in cells.withIndex()) {
            for ((x, item) in line.withIndex()) {
                if (normalVisited[y][x]) continue

                dfs(y, x, listOf(item), normalVisited)
                normalLastId++
            }
        }

        for ((y, line) in cells.withIndex()) {
            for ((x, item) in line.withIndex()) {
                if (blindVisited[y][x]) continue

                val colors = if (item == 'B') listOf('B') else listOf('R', 'G')
                dfs(y, x, colors, blindVisited)
                blindLastId++
            }
        }

        return normalLastId to blindLastId
    }

    private fun dfs(
        y: Int,
        x: Int,
        colors: List<Char>,
        visited: Array<Array<Boolean>>
    ) {
        if (visited[y][x]) return
        if (!colors.contains(cells[y][x])) return

        visited[y][x] = true

        val nextDiffs = listOf(1 to 0, 0 to 1, -1 to 0, 0 to -1)
        for ((yDiff, xDiff) in nextDiffs) {
            val newY = (yDiff + y).takeIf { it in visited.indices } ?: continue
            val newX = (xDiff + x).takeIf { it in visited.indices } ?: continue

            dfs(newY, newX, colors, visited)
        }
    }
}
