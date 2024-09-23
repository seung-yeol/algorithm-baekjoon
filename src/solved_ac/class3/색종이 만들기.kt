package solved_ac.class3

import java.io.BufferedReader

/**
 * **문제**
 * - 문제가 너무 길어서 하단의 링크에 진입해서 직접 확인 바람.
 *
 * **입력**
 * - 첫째 줄에는 전체 종이의 한 변의 길이 N이 주어져 있다. N은 2, 4, 8, 16, 32, 64, 128 중 하나이다.
 * - 색종이의 각 가로줄의 정사각형칸들의 색이 윗줄부터 차례로 둘째 줄부터 마지막 줄까지 주어진다.
 * - 하얀색으로 칠해진 칸은 0, 파란색으로 칠해진 칸은 1로 주어지며, 각 숫자 사이에는 빈칸이 하나씩 있다.
 *
 * **출력**
 * - 첫째 줄에는 잘라진 햐얀색 색종이의 개수를 출력하고, 둘째 줄에는 파란색 색종이의 개수를 출력한다.
 *
 * @see <a href="https://www.acmicpc.net/problem/2630">색종이 만들기</a>
 * */
fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val n = bufferedReader.readLine().toInt()
    val colorPaper = mutableListOf<List<Int>>()
    repeat(n) { colorPaper.add(bufferedReader.nextInts()) }

    val (white, blue) = colorPaper.count()
    println(white)
    println(blue)
}

private fun BufferedReader.nextInts(): List<Int> = readLine().split(" ").map(String::toInt)

private fun List<List<Int>>.count(): Paper {
    var isWhite = false
    var isBlue = false

    for (ints in this) {
        for (int in ints) {
            if (int == 0) isWhite = true
            if (int == 1) isBlue = true

            if (isWhite && isBlue) break
        }
    }

    if (isWhite && isBlue) {
        val dividedList = List(4) { index ->
            val nextListSize = this.size / 2
            val baseX = (index / 2) * nextListSize
            val baseY = index % 2 * nextListSize

            List(nextListSize) { x ->
                List(nextListSize) { y -> this[baseX + x][baseY + y] }
            }
        }
        return dividedList.fold(Paper(0, 0)) { acc, lists -> acc + lists.count() }
    }

    val white = if (isWhite) 1 else 0
    val blue = if (isBlue) 1 else 0
    return Paper(white, blue)
}

data class Paper(val white: Int, val blue: Int) {
    operator fun plus(other: Paper) = Paper(white + other.white, blue + other.blue)
}
