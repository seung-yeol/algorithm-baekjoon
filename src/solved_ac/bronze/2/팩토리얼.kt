package solved_ac.bronze.`2`

import java.math.BigInteger

/**
 * **문제**
 * - n!은 정수 n에 대한 팩토리얼 수를 나타내는데, 이는 1부터 n까지의 모든 정수의 곱을 의미한다.
 * - 팩토리얼은 굉장히 빨리 커지기 때문에 13!는 대부분의 컴퓨터에서 32비트 정수형을, 70!은 대부분의 부동 소수점 변수의 범위를 넘어선다.
 * - 우리는 n!에 대하여 0이 아닌 최우측 수(the rightmost non-zero digit)를 찾으려고 한다.
 * - 예를 들어, 5! = 1 * 2 * 3 * 4 * 5 = 120 이므로 5!의 최우측 0이 아닌 수는 2이다.
 * - 마찬가지로 7! = 1 * 2 * 3 * 4 * 5 * 6 * 7 = 5040이며 7!의 0이 아닌 최우측 수는 4가 된다.
 *
 * **입력**
 * - 첫 줄에 테스트 케이스의 수 t ( 0 < t < 15)가 주어진다. 연속하여 t개의 줄에는 정수 n이 하나씩 주어진다. ( 0 < n < 1001).
 *
 * **출력**
 * - n!의 최우측 0이 아닌 수(the rightmost non-zero digit)를 출력하시오.
 *
 * @see <a href="https://www.acmicpc.net/problem/7489">팩터리얼</a>
 * */
fun main() {
    val count = readln().toInt()

    for (i in 0 until count) {
        val target = readln().toInt()
        println(factorial(target))
    }
}

private fun factorial(value: Int): BigInteger {
    var result = 1.toBigInteger()
    for (i in 2..value) {
        result *= i.toBigInteger()

        while (result.remainder(10.toBigInteger()) == 0.toBigInteger()) {
            result /= 10.toBigInteger()
        }
    }

    return result % 10.toBigInteger()
}
