package solved_ac.class3

/**
 * **문제**
 * - 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
 * - 아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.
 *
 * **입력**
 * - 첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)
 *
 * **출력**
 * - 첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
 *
 * @see <img src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/11726/1.png"/>
 *
 * @see <a href="https://www.acmicpc.net/problem/11726">2xN 타일링</a>
 * */
fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val n = bufferedReader.readLine().toInt()
    val list = mutableListOf<Long>(1, 2)

    val answer = list.f(n)
    println(answer)
}

private fun MutableList<Long>.f(n: Int): Long {
    val value = getOrNull(n - 1)
    if (value != null) return value

    val newValue = (f(n - 1) + f(n - 2)) % 10_007
    add(newValue)

    return newValue
}