package solved_ac.class3

/**
 * **문제**
 * N+1개의 I와 N개의 O로 이루어져 있으면, I와 O이 교대로 나오는 문자열을 PN이라고 한다.
 * - P1 IOI
 * - P2 IOIOI
 * - P3 IOIOIOI
 * - PN IOIOI...OI (O가 N개)
 *
 * I와 O로만 이루어진 문자열 S와 정수 N이 주어졌을 때, S안에 PN이 몇 군데 포함되어 있는지 구하는 프로그램을 작성하시오.
 *
 * **입력**
 * - 첫째 줄에 N이 주어진다. 둘째 줄에는 S의 길이 M이 주어지며, 셋째 줄에 S가 주어진다.
 *
 * **출력**
 * - S에 PN이 몇 군데 포함되어 있는지 출력한다.
 *
 * **제한**
 * - 1 ≤ N ≤ 1,000,000
 * - 2N+1 ≤ M ≤ 1,000,000
 * - S는 I와 O로만 이루어져 있다.
 *
 * @see <a href="https://www.acmicpc.net/problem/5525">IOIOI</a>
 * */
fun main() {
    val n = readln().toInt()
    readln()
    val s = readln()

    println(Q5525().solve(s, n))
}

private class Q5525() {
    fun solve(s: String, n: Int): Int {
        val iois = findIOIs(s, n)

        var answer = 0
        for (value in iois) {
            answer += value + 1 - n
        }

        return answer
    }

    private fun findIOIs(s: String, n: Int): List<Int> {
        val sArray = s.toCharArray()
        val iois = mutableListOf<Int>()
        var index = 0
        var required = 'I'
        var count = -1

        while (index < sArray.size) {
            val current = sArray[index]
            if (current != required) {
                if (n <= count) iois.add(count)
                count = -1
            }

            if (current == 'I') {
                count++
                required = 'O'
            } else {
                required = 'I'
            }

            if (index == sArray.lastIndex) if (n <= count) iois.add(count)
            index++
        }

        return iois
    }
}
