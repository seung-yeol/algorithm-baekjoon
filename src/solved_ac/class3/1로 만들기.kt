package solved_ac.class3

import kotlin.math.min

/**
 * **문제** :
 *
 * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
 *
 * 1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
 *
 * 2. X가 2로 나누어 떨어지면, 2로 나눈다.
 *
 * 3. 1을 뺀다.
 *
 * 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
 *
 * **입력** :
 *
 * 첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.
 *
 * **출력** :
 *
 * 첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
 *
 * @see <a href="https://www.acmicpc.net/problem/1463">1로 만들기</a>
 * */

fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val count = Operator().run(bufferedReader.readLine().toInt())
    println(count)
}

private class Operator {
    private var minCount = Int.MAX_VALUE

    fun run(number: Int, count: Int = 0): Int {
        if (minCount < count) return Int.MAX_VALUE

        if (number < 2) {
            minCount = min(minCount, count)
            return count
        }

        return min(
            run(number / 3, count + number % 3 + 1),
            run(number / 2, count + number % 2 + 1)
        )
    }
}
