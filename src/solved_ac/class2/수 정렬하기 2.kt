package solved_ac.class2

import java.io.BufferedReader

/**
 * **문제** : N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오
 *
 * **입력** : 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
 *
 * **출력** : 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 *
 * counting sort 방법을 사용함.
 * 이 방법은 수의 범위가 작지만, 제공되는 숫자들의 갯수가 많은 경우에 쓰면 좋음
 *
 * @see <a href="https://www.acmicpc.net/problem/2751">수 정렬하기 2</a>
 * */
fun main() {
    val br = System.`in`.bufferedReader()
    val count = br.nextInt()
    val numbers = IntArray(count)

    repeat(count) {
        numbers[it] = br.nextInt()
    }

    val joined = numbers.sorted().joinToString(separator = "") { "$it\n" }
    println(joined)

}

private fun BufferedReader.nextInt() = readLine().toInt()
