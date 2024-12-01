package solved_ac.class3

import kotlin.math.max
import kotlin.math.min

/**
 * **문제**
 * - 카잉 제국의 백성들은 특이한 달력을 사용한 것으로 알려져 있다.
 * - 그들은 M과 N보다 작거나 같은 두 개의 자연수 x, y를 가지고 각 년도를 <x:y>와 같은 형식으로 표현하였다.
 * - 그들은 이 세상의 시초에 해당하는 첫 번째 해를 <1:1>로 표현하고, 두 번째 해를 <2:2>로 표현하였다.
 * - <x:y>의 다음 해를 표현한 것을 <x':y'>이라고 하자.
 * - 만일 x < M 이면 x' = x + 1이고, 그렇지 않으면 x' = 1이다.
 * - 같은 방식으로 만일 y < N이면 y' = y + 1이고, 그렇지 않으면 y' = 1이다.
 * - <M:N>은 그들 달력의 마지막 해로서, 이 해에 세상의 종말이 도래한다는 예언이 전해 온다.
 * - 예를 들어, M = 10 이고 N = 12라고 하자. 첫 번째 해는 <1:1>로 표현되고, 11번째 해는 <1:11>로 표현된다.
 * - <3:1>은 13번째 해를 나타내고, <10:12>는 마지막인 60번째 해를 나타낸다.
 * - 네 개의 정수 M, N, x와 y가 주어질 때, <M:N>이 카잉 달력의 마지막 해라고 하면 <x:y>는 몇 번째 해를 나타내는지 구하는 프로그램을 작성하라.
 *
 * **입력**
 * - 입력 데이터는 표준 입력을 사용한다. 입력은 T개의 테스트 데이터로 구성된다.
 * - 입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가 주어진다.
 * - 각 테스트 데이터는 한 줄로 구성된다.
 * - 각 줄에는 네 개의 정수 M, N, x와 y가 주어진다.
 * - (1 ≤ M, N ≤ 40,000, 1 ≤ x ≤ M, 1 ≤ y ≤ N) 여기서 <M:N>은 카잉 달력의 마지막 해를 나타낸다.
 *
 * **출력**
 * - 출력은 표준 출력을 사용한다. 각 테스트 데이터에 대해, 정수 k를 한 줄에 출력한다.
 * - 여기서 k는 <x:y>가 k번째 해를 나타내는 것을 의미한다.
 * - 만일 <x:y>에 의해 표현되는 해가 없다면, 즉, <x:y>가 유효하지 않은 표현이면, -1을 출력한다.
 *
 * @see <a href="https://www.acmicpc.net/problem/6064">카잉달력</a>
 * */
fun main() {
    val count = readln().toInt()
    val strings = mutableListOf<String>()
    repeat(count) { strings.add(readln()) }

    val stringBuilder = StringBuilder()
    Q6064().solve(strings).forEach(stringBuilder::appendLine)
    println(stringBuilder)
}

private class Q6064() {
    fun solve(strings: List<String>): List<Int> {
        val answers = mutableListOf<Int>()
        strings.forEach {
            val (m, n, x, y) = it.split(" ").map(String::toInt)
            answers.add(solve(m, n, x, y))
        }

        return answers
    }

    // 1. answer = m * a + x = n * b + y
    // 2. b = (m * a + x - y) / n
    // a와 b가 정수이면서 m과 n의 최소공배수 이하의 answer를 구하면 됨.
    private fun solve(m: Int, n: Int, x: Int, y: Int): Int {
        val lcm = calculateLCM(m, n)
        var a = 0

        while (true) {
            val answer = m * a + x
            if (lcm < answer) return -1
            if ((answer - y) % n == 0) return answer
            a++
        }
    }

    private fun calculateLCM(m: Int, n: Int): Int = m * n / calculateGCD(m, n)

    private fun calculateGCD(m: Int, n: Int): Int {
        var nextM = max(m, n)
        var nextN = min(m, n)
        while (true) {
            val remainder = nextM % nextN
            if (remainder == 0) return nextN

            nextM = nextN
            nextN = remainder
        }
    }
}
