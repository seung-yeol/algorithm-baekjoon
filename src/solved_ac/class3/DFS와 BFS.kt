package solved_ac.class3

import java.io.BufferedReader
import java.util.*

/**
 * **문제**
 * - 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
 * - 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
 * - 정점 번호는 1번부터 N번까지이다.
 *
 * **입력**
 * - 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
 * - 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
 * - 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다.
 * - 입력으로 주어지는 간선은 양방향이다.
 *
 * **출력**
 * - 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다.
 * - V부터 방문된 점을 순서대로 출력하면 된다.
 *
 * @see <a href="https://www.acmicpc.net/problem/1260">DFS와 BFS</a>
 * */
fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val (pointCount, sideCount, startPoint) = bufferedReader.nextInts()
    val stringBuilder = StringBuilder()

    val pointArray = Array(pointCount + 1) { BooleanArray(pointCount + 1) }
    repeat(sideCount) {
        val (point, otherPoint) = bufferedReader.nextInts()
        pointArray[point][otherPoint] = true
        pointArray[otherPoint][point] = true
    }

    stringBuilder.appendLine(pointArray.dfs(startPoint).joinToString(" "))
    stringBuilder.appendLine(pointArray.bfs(startPoint).joinToString(" "))
    println(stringBuilder)
}

private fun BufferedReader.nextInts(): IntArray = readLine().split(" ").map(String::toInt).toIntArray()

private fun Array<BooleanArray>.dfs(startPoint: Int, visited: MutableList<Int> = mutableListOf(startPoint)): List<Int> {
    for ((endPoint, isConnected) in this[startPoint].withIndex()) {
        if (!isConnected) continue
        if (visited.contains(endPoint)) continue

        visited.add(endPoint)
        dfs(endPoint, visited)
    }
    return visited
}

private fun Array<BooleanArray>.bfs(startPoint: Int): List<Int> {
    val visited = mutableListOf<Int>()
    val queue = LinkedList<Int>().apply { add(startPoint) }
    while (queue.isNotEmpty()) {
        val endPoint = queue.removeFirst()
        if (visited.contains(endPoint)) continue

        visited.add(endPoint)
        for ((newStartPoint, isConnected) in this[endPoint].withIndex()) {
            if (!isConnected) continue
            if (visited.contains(newStartPoint)) continue

            queue.add(newStartPoint)
        }
    }

    return visited
}
