package solved_ac.class3

import java.io.BufferedReader

/**
 * **문제** :
 *
 * 오른쪽 그림과 같이 삼각형이 나선 모양으로 놓여져 있다.
 *
 * - 첫 삼각형은 정삼각형으로 변의 길이는 1이다.
 * - 그 다음에는 다음과 같은 과정으로 정삼각형을 계속 추가한다.
 * - 나선에서 가장 긴 변의 길이를 k라 했을 때, 그 변에 길이가 k인 정삼각형을 추가한다.
 *
 * 파도반 수열 P(N)은 나선에 있는 정삼각형의 변의 길이이다. P(1)부터 P(10)까지 첫 10개 숫자는 1, 1, 1, 2, 2, 3, 4, 5, 7, 9이다.
 *
 * N이 주어졌을 때, P(N)을 구하는 프로그램을 작성하시오.
 *
 * **입력** :
 *
 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. (1 ≤ N ≤ 100)
 *
 * **출력** :
 *
 * 각 테스트 케이스마다 P(N)을 출력한다.
 *
 * @see <img src="https://www.acmicpc.net/upload/images/pandovan.png"/>
 *
 * @see <a href="https://www.acmicpc.net/problem/9461">파도반 수열</a>
 * */
fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val sides = mutableListOf<Long>(1, 1, 1, 2, 2)
    val stringBuilder = StringBuilder()

    repeat(bufferedReader.nextInt()) {
        val side = sides.find(bufferedReader.nextInt())
        stringBuilder.appendLine(side)
    }

    println(stringBuilder)
}

private fun BufferedReader.nextInt() = readLine().toInt()

private fun MutableList<Long>.find(n: Int): Long {
    val side = getOrNull(n - 1)
    if (side != null) return side

    return (find(n - 1) + find(n - 5)).also(::add)
}
