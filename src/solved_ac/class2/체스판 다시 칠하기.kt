package solved_ac.class2

import kotlin.math.min

/**
 * @see <a href="https://www.acmicpc.net/problem/1018">체스판 다시 칠하기</a>
 *
 * 지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M×N 크기의 보드를 찾았다.
 * 어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다.
 * 지민이는 이 보드를 잘라서 8×8 크기의 체스판으로 만들려고 한다.
 *
 * 첫째 줄에 N과 M이 주어진다.
 * N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다.
 * 둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다.
 * B는 검은색이며, W는 흰색이다.
 *
 * 체스판이 만들어지기 위해 다시 칠해야하는 최소 개수를 출력하라.
 * */
fun main() {
    val (h, w) = readln().split(" ").map(String::toInt)

    val arrays = Array(h) { "" }
    repeat(h) { arrays[it] = readln() }

    var startX = 0
    var startY: Int
    var answer = Int.MAX_VALUE

    while (startX + 7 < w) {
        startY = 0
        while (startY + 7 < h) {
            val newChess = Array(8) { arrays[it + startY].substring(startX..startX + 7) }
            val countDiff = newChess.countDiff()
            answer = min(answer, min(countDiff, 64 - countDiff) )

            startY++
        }

        startX++
    }

    println(answer)
}

private fun Array<String>.countDiff(): Int {
    var count = 0
    for ((index, value) in withIndex()) {
        count += value.countDiff(index % 2 == 0)
    }

    return count
}

private fun String.countDiff(isReverse: Boolean): Int {
    var count = 0
    for ((index, value) in withIndex()) {
        val color = if ((index % 2 == 0).xor(isReverse)) 'W' else 'B'
        if (value != color) count++
    }

    return count
}