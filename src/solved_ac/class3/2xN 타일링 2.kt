package solved_ac.class3

/**
 * **문제**
 * - 2×n 직사각형을 1×2, 2×1과 2×2 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
 * - 아래 그림은 2×17 직사각형을 채운 한가지 예이다.
 *
 * **입력**
 * - 첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)
 *
 * **출력**
 * - 첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
 *
 * @see <img src="https://www.acmicpc.net/upload/images/t2n2122.gif"/>
 *
 * @see <a href="https://www.acmicpc.net/problem/11727">2xN 타일링 2</a>
 * */
fun main() {
    val n = readln().toInt()
    val list = mutableListOf(1, 3)
    val answer = list.f(n)
    println(answer)
}

private fun MutableList<Int>.f(n: Int): Int {
    val value = getOrNull(n - 1)
    if (value != null) return value

    val newValue = (f(n - 1) + f(n - 2) * 2) % 10_007
    add(newValue)

    return newValue
}
