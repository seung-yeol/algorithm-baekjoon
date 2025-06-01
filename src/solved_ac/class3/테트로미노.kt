package solved_ac.class3

/**
 * **문제**
 * 폴리오미노란 크기가 1×1인 정사각형을 여러 개 이어서 붙인 도형이며, 다음과 같은 조건을 만족해야 한다.
 *
 * - 정사각형은 서로 겹치면 안 된다.
 * - 도형은 모두 연결되어 있어야 한다.
 * - 정사각형의 변끼리 연결되어 있어야 한다. 즉, 꼭짓점과 꼭짓점만 맞닿아 있으면 안 된다.
 * - 정사각형 4개를 이어 붙인 폴리오미노는 테트로미노라고 하며, 다음과 같은 5가지가 있다.
 *
 *  아름이는 크기가 N×M인 종이 위에 테트로미노 하나를 놓으려고 한다. 종이는 1×1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 정수가 하나 쓰여 있다.
 *
 *  테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로 하는 프로그램을 작성하시오.
 *
 *  테트로미노는 반드시 한 정사각형이 정확히 하나의 칸을 포함하도록 놓아야 하며, 회전이나 대칭을 시켜도 된다.
 *
 * **입력**
 * - 첫째 줄에 종이의 세로 크기 N과 가로 크기 M이 주어진다. (4 ≤ N, M ≤ 500)
 *
 * - 둘째 줄부터 N개의 줄에 종이에 쓰여 있는 수가 주어진다. i번째 줄의 j번째 수는 위에서부터 i번째 칸, 왼쪽에서부터 j번째 칸에 쓰여 있는 수이다. 입력으로 주어지는 수는 1,000을 넘지 않는 자연수이다.
 *
 * **출력**
 * - 첫째 줄에 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값을 출력한다.
 *
 * @see <a href="https://www.acmicpc.net/problem/14500">테트로미노</a>
 * */
fun main() {
    val (n, m) = readInts()

    println(Q14500(n, m).run())
}

private fun readInts(): List<Int> = readln().split(" ").map(String::toInt)

private class Q14500(private val n: Int, private val m: Int) {
    private val visited = Array(n) { BooleanArray(m) }
    private val coords = mutableListOf<List<Int>>()
    private val directions = listOf(
        listOf(1, 0),
        listOf(0, 1),
        listOf(-1, 0),
        listOf(0, -1)
    )

    init {
        for (i in 0 until n) {
            coords.add(readInts())
        }
    }

    fun run(): Int {
        var max = 0
        for (y in 0..<n) {
            for (x in 0..<m) {
                val resultDfs = checkDfs(x = x, y = y)
                val resultㅗ = checkㅗ(x = x, y = y)

                val maxOf = maxOf(resultㅗ, resultDfs)
                if (max < maxOf) max = maxOf
            }
        }

        return max
    }

    private fun checkDfs(x: Int, y: Int): Int = dfs(x = x, y = y, sum = coords[y][x], stage = 2)

    private fun dfs(x: Int, y: Int, sum: Int, stage: Int): Int {
        var max = 0

        visited[y][x] = true
        for ((dx, dy) in directions) {
            val nextX = x + dx
            val nextY = y + dy
            if (nextX !in 0..<m || nextY !in 0..<n) continue

            if (visited[nextY][nextX]) continue

            val next = coords[nextY][nextX]
            val nextSum = sum + next

            if (stage == 4) {
                if (max < nextSum) max = nextSum
            } else {
                visited[nextY][nextX] = true
                val newDfs = dfs(x = nextX, y = nextY, sum = nextSum, stage = stage + 1)
                if (max < newDfs) max = newDfs
            }
        }
        visited[y][x] = false

        return max
    }

    private fun checkㅗ(x: Int, y: Int): Int {
        val current = coords[y][x]
        val points = directions.mapNotNull { (dx, dy) ->
            val newX = x + dx
            val newY = y + dy
            if (newX in 0..<m && newY in 0..<n) listOf(x + dx, y + dy) else null
        }

        if (points.size < 3) return 0

        val nextValues = points.map { (x, y) -> coords[y][x] }
        val nextSum = nextValues.sum()
        if (points.size == 3) return current + nextSum

        var max = 0
        for (value in nextValues) {
            val candidate = nextSum - value
            if (max < candidate) max = candidate
        }

        return current + max
    }
}
