package solved_ac.class3

import java.io.BufferedReader
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

/**
 * **문제**
 * - 도연이가 다니는 대학의 캠퍼스는 N * M크기이며 캠퍼스에서 이동하는 방법은 벽이 아닌 상하좌우로 이동하는 것이다.
 * - 예를 들어, 도연이가 (x, y)에 있다면 이동할 수 있는 곳은 (x+1, y), (x, y+1), (x-1,y), (x, y-1)이다.
 * - 단, 캠퍼스의 밖으로 이동할 수는 없다.
 * - 캠퍼스에서 도연이가 만날 수 있는 사람의 수를 출력하는 프로그램을 작성해보자.
 *
 * **입력**
 * - 첫째 줄에는 캠퍼스의 크기를 나타내는 두 정수 N(1 <= N <= 600), M(1 <= M <= 600)이 주어진다.
 * - 둘째 줄부터 N개의 줄에는 캠퍼스의 정보들이 주어진다.
 * - O는 빈 공간, X는 벽, I는 도연이, P는 사람이다. I가 한 번만 주어짐이 보장된다.
 *
 * **출력**
 * - 첫째 줄에 도연이가 만날 수 있는 사람의 수를 출력한다. 단, 아무도 만나지 못한 경우 TT를 출력한다.
 *
 * @see <a href="https://www.acmicpc.net/problem/21736">헌내기는 친구가 필요해</a>
 * */
fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val (n, _) = bufferedReader.nextInts()
    val coords = mutableListOf<CharArray>()

    var x = 0
    var y = 0
    repeat(n) {
        val chars = bufferedReader.readLine().toCharArray()
        val index = chars.indexOfFirst { it == 'I' }
        if (index != -1) {
            x = it
            y = index
        }
        coords.add(chars)
    }

    val answer = coords.dfs(x, y).takeIf { it != 0 }?.toString() ?: "TT"
    println(answer)
}

private fun List<CharArray>.dfs(x: Int, y: Int): Int {
    var count = 0

    val value = this[x][y]
    if (value == 'X') return 0

    if (value == 'P') count++
    this[x][y] = 'X'

    val xRange = max(0, x - 1)..min(lastIndex, x + 1)
    val yRange = max(0, y - 1)..min(this[x].lastIndex, y + 1)
    for (newX in xRange) {
        for (newY in yRange) {
            if (abs(x - newX + y - newY) != 1) continue

            count += dfs(newX, newY)
        }
    }

    return count
}

private fun BufferedReader.nextInts(): IntArray = readLine().split(" ").map(String::toInt).toIntArray()
