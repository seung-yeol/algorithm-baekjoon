package solved_ac.class2

import java.util.*

/**
 * @see <a href="https://www.acmicpc.net/problem/2775">부녀회장이 될테야</a>
 *
 * a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다는 계약 조항을 꼭 지키고 들어와야 한다.
 *
 * 아파트에 비어있는 집은 없고 모든 거주민들이 이 계약 조건을 지키고 왔다고 가정했을 때, k층에 n호에는 몇 명이 살고 있는지 출력하라.
 * 단, 아파트에는 0층부터 있고 각 층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.
 *
 * 첫 번째 줄에 Test case의 수 T가 주어진다.
 * 그리고 각각의 케이스마다 입력으로 첫 번째 줄에 정수 k, 두 번째 줄에 정수 n이 주어진다.
 * 각각의 Test case에 대해서 해당 집에 거주민 수를 출력하라.
 * */
fun main() {
    val buffer = System.`in`.bufferedReader()
    val scanner = Scanner(buffer)
    val stringBuilder = StringBuilder()
    val apartments = mutableListOf(IntArray(15) { it })

    repeat(scanner.nextInt()) {
        val k = scanner.nextInt()
        val n = scanner.nextInt()
        val headCount = apartments[k, n] ?: apartments.calculate(k, n)
        stringBuilder.appendLine(headCount)
    }
    println(stringBuilder)
}

private operator fun MutableList<IntArray>.get(k: Int, n: Int): Int? = getOrNull(k)?.getOrNull(n)?.takeIf { it != 0 }

private fun MutableList<IntArray>.calculate(k: Int, n: Int): Int {
    (size - 1 until k).forEach { height ->
        val bottomFloor = get(height)
        val newFloor = IntArray(15).also { add(it) }
        (1..14).forEach { roomNumber ->
            newFloor[roomNumber] = newFloor[roomNumber - 1] + bottomFloor[roomNumber]
        }
    }

    return this[k, n]!!
}