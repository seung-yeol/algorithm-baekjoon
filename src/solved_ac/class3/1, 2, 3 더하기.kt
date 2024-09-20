package solved_ac.class3

import java.io.BufferedReader

/**
 * **문제** :
 *
 * 정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
 * 1. 1+1+1+1
 * 2. 1+1+2
 * 3. 1+2+1
 * 4. 2+1+1
 * 5. 2+2
 * 6. 1+3
 * 7. 3+1
 *
 * 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
 *
 * **입력** :
 *
 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 11보다 작다.
 *
 * **출력** :
 *
 * 각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 출력한다.
 *
 * @see <a href="https://www.acmicpc.net/problem/9095">1, 2, 3 더하기</a>
 * */
fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val stringBuilder = StringBuilder()
    val counter = Counter()

    repeat(bufferedReader.nextInt()) {
        stringBuilder.appendLine(counter.find(bufferedReader.nextInt()))
    }

    println(stringBuilder)
}

private fun BufferedReader.nextInt() = readLine().toInt()

private class Counter {
    private val memo: MutableList<Int> = mutableListOf<Int>().apply {
        add(0)
        add(1)
        add(2)
        add(4)
    }

    fun find(n: Int): Int {
        if (n < 4) return memo[n]

        val memoized = memo.getOrNull(n) ?: run {
            memo.add(find(n - 1) + find(n - 2) + find(n - 3))
            memo[n]
        }

        return memoized
    }
}
