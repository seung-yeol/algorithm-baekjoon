package programmers

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

/**
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/87377?language=kotlin">교점에 별 만들기</a>
 * */
fun main() {
    Solution()
        .solution(
            arrayOf(
                intArrayOf(2, -1, 4),
                intArrayOf(-2, -1, 4),
                intArrayOf(0, -1, 1),
                intArrayOf(5, -8, -12),
                intArrayOf(5, 8, 12),
            )
        ).also { it.forEach { println(it) } }
}

class Solution {
    fun solution(line: Array<IntArray>): Array<String> {
        val points = mutableSetOf<Pair<Int, Int>>()
        line.forEachIndexed { firstIndex, first ->
            for ((index, second) in line.withIndex()) {
                if (firstIndex == index) continue

                findDot(first, second)?.let(points::add)
            }
        }

        var minX = Int.MAX_VALUE
        var maxX = Int.MIN_VALUE
        var minY = Int.MAX_VALUE
        var maxY = Int.MIN_VALUE
        points.forEach { (x, y) ->
            minX = min(minX, x)
            maxX = max(maxX, x)
            minY = min(minY, y)
            maxY = max(maxY, y)
        }

        val ySize = abs(maxY - minY + 1)
        val xSize = abs(maxX - minX + 1)

        val sb = StringBuilder()
        for (i in 0 until xSize) {
            sb.append(".")
        }

        val answer = Array(ySize) { sb.toString() }
        points.forEach { (x, y) ->
            val yPoint = y - minY
            val xPoint = x - minX
            val string = answer[yPoint]
            answer[yPoint] = string.substring(0, xPoint) + "*" + string.substring(xPoint + 1)
        }

        return answer.reversedArray()
    }
}

private fun findDot(first: IntArray, second: IntArray): Pair<Int, Int>? {
    val bottom = first[0].toLong() * second[1] - second[0].toLong() * first[1]
    if (bottom == 0L) return null

    val xTop = first[1].toLong() * second[2] - second[1].toLong() * first[2]
    val yTop = second[0].toLong() * first[2] - first[0].toLong() * second[2]
    if (xTop % bottom != 0L || yTop % bottom != 0L) return null

    return (xTop / bottom).toInt() to (yTop / bottom).toInt()
}