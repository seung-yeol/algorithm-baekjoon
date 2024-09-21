package solved_ac.class3

import java.io.BufferedReader

/**
 * **문제**
 * - 지렁이는 배추근처에 서식하며 해충을 잡아 먹음으로써 배추를 보호한다.
 * - 어떤 배추에 지렁이가 한 마리라도 살고 있으면, 이 지렁이는 인접한 다른 배추로 이동할 수 있어, 그 배추들 역시 해충으로부터 보호받을 수 있다.
 * - 한 배추의 상하좌우 네 방향에 다른 배추가 위치한 경우에 서로 인접해있는 것이다.
 * - 배추들이 모여있는 곳에는 지렁이가 한 마리만 있으면 되므로 서로 인접해있는 배추들이 몇 군데에 퍼져있는지 조사하면 총 몇 마리의 지렁이가 필요한지 알 수 있다.
 *
 * **입력**
 * - 입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다.
 * - 그 다음 줄부터 각각의 테스트 케이스에 대해 첫째 줄에는 배추를 심은 배추밭의 가로길이 M(1 ≤ M ≤ 50)과 세로길이 N(1 ≤ N ≤ 50), 그리고 배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)이 주어진다.
 * - 그 다음 K줄에는 배추의 위치 X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)가 주어진다.
 * - 두 배추의 위치가 같은 경우는 없다.
 *
 * **출력**
 * - 각 테스트 케이스에 대해 필요한 최소의 지렁이 마리 수를 출력한다.
 *
 * @see <a href="https://www.acmicpc.net/problem/1012">유기농 배추</a>
 * */
fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val questionCount = bufferedReader.readLine().toInt()
    val stringBuilder = StringBuilder()

    repeat(questionCount) {
        val cabbageArray = bufferedReader.createCabbageArray()
        val count = cabbageArray.getWormCount()
        stringBuilder.appendLine(count)
    }

    println(stringBuilder)
}

private fun BufferedReader.nextInts(): IntArray = readLine().split(" ").map(String::toInt).toIntArray()

private fun BufferedReader.createCabbageArray(): Array<BooleanArray> {
    val (width, height, cabbageCount) = nextInts()
    val cabbageArray = Array(width) { BooleanArray(height) }
    repeat(cabbageCount) {
        val (x, y) = nextInts()
        cabbageArray[x][y] = true
    }
    return cabbageArray
}

private fun Array<BooleanArray>.removeWorm(x: Int, y: Int) {
    if (this[x][y]) {
        this[x][y] = false
        if (x != 0) removeWorm(x - 1, y)
        if (x != lastIndex) removeWorm(x + 1, y)
        if (y != 0) removeWorm(x, y - 1)
        if (y != first().lastIndex) removeWorm(x, y + 1)
    }
}

private fun Array<BooleanArray>.getWormCount(): Int {
    var count = 0
    for ((x, line) in withIndex()) {
        for ((y, exist) in line.withIndex()) {
            if (exist) {
                count++
                removeWorm(x, y)
            }
        }
    }
    return count
}
