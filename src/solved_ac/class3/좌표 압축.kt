package solved_ac.class3

import java.io.BufferedReader

/**
 * **문제**
 * - 수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.
 * - Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표 Xj의 개수와 같아야 한다.
 * - X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.
 *
 * **입력**
 * - 첫째 줄에 N이 주어진다.
 * - 둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.
 * - 1 ≤ N ≤ 1,000,000
 * - -10^9 ≤ Xi ≤ 10^9
 *
 * **출력**
 * - 첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.
 *
 * @see <a href="https://www.acmicpc.net/problem/18870">좌표 압축</a>
 * */
fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val n = bufferedReader.readLine()
    val coords = bufferedReader.nextInts()
    val sorted = coords.sorted()

    val map = mutableMapOf<Int, Int>()
    var rank = 0
    for (coord in sorted) {
        if (!map.contains(coord)) map[coord] = rank++
    }

    val rankMap = mutableMapOf<Int, Int>()
    for ((index, coord) in map.keys.sorted().withIndex()) {
        rankMap[coord] = index
    }

    println(coords.map(rankMap::get).joinToString(" "))
}

private fun BufferedReader.nextInts(): IntArray = readLine().split(" ").map(String::toInt).toIntArray()
