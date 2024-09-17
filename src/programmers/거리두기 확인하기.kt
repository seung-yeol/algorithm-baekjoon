package programmers

import kotlin.math.abs


/**
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/81302">거리두기 확인하기</a>
 * */

/**
 * **문제** :
 *
 * 아래와 같은 규칙으로 대기실에 거리를 두고 앉도록 안내하고 있습니다.
 *
 * 대기실은 5개이며, 각 대기실은 5x5 크기입니다.
 *
 * 거리두기를 위하여 응시자들 끼리는 맨해튼 거리1가 2 이하로 앉지 말아 주세요.
 *
 * 단 응시자가 앉아있는 자리 사이가 파티션으로 막혀 있을 경우에는 허용합니다.
 *
 * **입력** :
 *
 * ["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"],
 *
 * ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"],
 *
 * ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"],
 *
 * ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"],
 *
 * ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]
 *
 * **출력** :
 *
 * [1, 0, 1, 1, 1]
 *
 * @see <a href="https://www.acmicpc.net/problem/"></a>
 * */
fun main() {
    val arr: Array<Array<String>> = arrayOf(
        arrayOf("POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"),
        arrayOf("POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"),
        arrayOf("PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"),
        arrayOf("OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"),
        arrayOf("PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"),
    )
    solution(arr)
}

fun solution(places: Array<Array<String>>): IntArray {
    val answer = IntArray(5)

    for ((index, place) in places.withIndex()) {
        val room = Place(place.map { it.toCharArray() }.toTypedArray())
        val isSafe = room.check()
        answer[index] = if (isSafe) 1 else 0
    }

    println(answer.joinToString(", "))

    return answer
}

private class Place(private val place: Array<CharArray>) {
    fun check(): Boolean {
        for (x in place.indices) {
            for ((y, value) in place[x].withIndex()) {
                if (value != 'P') continue

                if (!isSafe(x, y)) return false
            }
        }

        return true
    }

    private fun isSafe(x: Int, y: Int): Boolean {
        val otherXRange = (x - 2).coerceAtLeast(0)..(x + 2).coerceAtMost(place.lastIndex)
        val otherYRange = (y - 2).coerceAtLeast(0)..(y + 2).coerceAtMost(place[x].lastIndex)

        for (otherX in otherXRange) {
            for (otherY in otherYRange) {
                if (otherX == x && otherY == y) continue

                if (!XY(x, y).isSafeWith(other = XY(otherX, otherY))) return false
            }
        }

        return true
    }


    private fun XY.isSafeWith(other: XY): Boolean {
        require(this != other)

        if (place[other.x][other.y] != 'P') return true

        val distance = abs(x - other.x) + abs(y - other.y)
        return when (distance) {
            2 -> isSafeWhenDistance2(other)
            1 -> false
            else -> true
        }
    }

    private fun XY.isSafeWhenDistance2(other: XY): Boolean {
        if (x == other.x) {
            val betweenY = (y + other.y) / 2
            return place[x][betweenY] == 'X'
        }

        if (y == other.y) {
            val betweenX = (x + other.x) / 2
            return place[betweenX][y] == 'X'
        }

        return place[x][other.y] == 'X' && place[other.x][y] == 'X'
    }

    private data class XY(val x: Int, val y: Int)
}
