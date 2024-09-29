package solved_ac.class3

import java.io.BufferedReader

/**
 * **문제**
 * - 마인크래프트는 1 × 1 × 1 크기의 블록들로 이루어진 3차원 세계에서 자유롭게 땅을 파거나 집을 지을 수 있는 게임이다.
 * - 고르지 않은 땅에는 집을 지을 수 없기 때문에 땅의 높이를 모두 동일하게 만드는 ‘땅 고르기’ 작업을 해야 한다.
 * - 세로 N, 가로 M 크기의 집터를 골랐다. 집터 맨 왼쪽 위의 좌표는 (0, 0)이다.
 * - 우리의 목적은 이 집터 내의 땅의 높이를 일정하게 바꾸는 것이다. 우리는 다음과 같은 두 종류의 작업을 할 수 있다.
 * 1. 좌표 (i, j)의 가장 위에 있는 블록을 제거하여 인벤토리에 넣는다. 수행시간 : 2초
 * 2. 블록 하나를 꺼내어 좌표 (i, j)의 가장 위에 있는 블록 위에 놓는다. 수행시간 : 1초
 * - 집터 아래에 빈 공간은 존재하지 않으며, 집터 바깥에서 블록을 가져올 수 없다.
 * - 또한, 작업을 시작할 때 인벤토리에는 B개의 블록이 들어 있다.
 * - 땅의 높이는 256블록을 초과할 수 없으며, 음수가 될 수 없다.
 * - 땅 고르기 작업에 걸리는 최소 시간과 그 경우 땅의 높이를 출력하시오.
 *
 * **입력**
 * - 첫째 줄에 N, M, B가 주어진다. (1 ≤ M, N ≤ 500, 0 ≤ B ≤ 6.4 × 10^7)
 * - 둘째 줄부터 N개의 줄에 각각 M개의 정수로 땅의 높이가 주어진다. (i + 2)번째 줄의 (j + 1)번째 수는 좌표 (i, j)에서의 땅의 높이를 나타낸다.
 * - 땅의 높이는 256보다 작거나 같은 자연수 또는 0이다.
 *
 * **출력**
 * - 첫째 줄에 땅을 고르는 데 걸리는 시간과 땅의 높이를 출력하시오. 답이 여러 개 있다면 그중에서 땅의 높이가 가장 높은 것을 출력하시오.
 *
 * @see <a href="https://www.acmicpc.net/problem/18111">마인크래프트</a>
 * */
fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val (n, _, b) = bufferedReader.nextInts()

    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE

    val blocs = mutableListOf<Int>()
    repeat(n) {
        val line = bufferedReader.nextInts()
        for (i in line) {
            if (i < min) min = i
            else if (max < i) max = i
        }
        blocs.addAll(line)
    }

    var minDuration = Int.MAX_VALUE
    var maxHeight = 0
    for (height in min..max) {
        var fillCount = 0
        var digCount = 0
        for (i in blocs) {
            if (i < height) fillCount += height - i
            if (height < i) digCount += i - height
        }

        if (digCount - fillCount + b < 0) continue

        val duration = fillCount + digCount * 2
        if (minDuration < duration) continue

        if (minDuration == duration) {
            if (maxHeight < height) {
                maxHeight = height
            }
            continue
        }

        if (duration < minDuration) {
            minDuration = duration
            maxHeight = height
        }
    }

    println("$minDuration $maxHeight")
}

private fun BufferedReader.nextInts(): List<Int> = readLine().split(" ").map(String::toInt)
