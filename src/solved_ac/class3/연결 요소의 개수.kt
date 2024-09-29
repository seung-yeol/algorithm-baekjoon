package solved_ac.class3

import java.io.BufferedReader

/**
 * **문제**
 * - 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
 *
 * **입력**
 * - 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2)
 * - 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.
 *
 * **출력**
 * - 첫째 줄에 연결 요소의 개수를 출력한다.
 *
 * @see <a href="https://www.acmicpc.net/problem/11724">연결 요소의 개수</a>
 * */
fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val (nodeCount, linkCount) = bufferedReader.nextInts()
    val graph = Array(nodeCount + 1) { x -> BooleanArray(nodeCount + 1) { y -> x == y } }

    repeat(linkCount) {
        val (x, y) = bufferedReader.nextInts()
        graph[x][y] = true
        graph[y][x] = true
    }

    var count = 0
    for (start in 1..nodeCount) {
        if (graph.dfs(start)) count++
    }
    println(count)
}

private fun Array<BooleanArray>.dfs(start: Int): Boolean {
    var isExist = false
    for ((end, isConnected) in this[start].withIndex()) {
        if (!isConnected) continue

        isExist = true
        this[start][end] = false
        this[end][start] = false

        dfs(end)
    }

    return isExist
}

private fun BufferedReader.nextInts(): IntArray = readLine().split(" ").map(String::toInt).toIntArray()