package solved_ac.class2

import java.io.BufferedReader

/**
 * **문제** : N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 *
 * **입력** : 첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.
 *
 * **출력** : 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 *
 * counting sort 방법을 사용함.
 * 이 방법은 수의 범위가 작지만, 제공되는 숫자들의 갯수가 많은 경우에 쓰면 좋음
 *
 * @see <a href="https://www.acmicpc.net/problem/10989">수 정렬하기 3</a>
 * @see <a href="https://namu.wiki/w/%EC%A0%95%EB%A0%AC%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98#s-4.4.2">Counting sort</a>
 * */

fun main() {
    val br = System.`in`.bufferedReader()
    val count = br.nextInt()
    val numbers = IntArray(count)
    var max = 0

    for (i in 0 until count) {
        val next = br.nextInt()
        if (next > max) max = next
        numbers[i] = next
    }

    val counts = IntArray(max + 1)
    for (i in numbers) {
        counts[i] = counts[i] + 1
    }

    for (index in counts.indices) {
        if (index == 0) continue

        counts[index] += counts[index - 1]
    }

    val answers = IntArray(numbers.size)
    numbers.forEach {
        val index = counts[it] - 1
        counts[it] -= 1
        answers[index] = it
    }

    val sb = StringBuilder()
    answers.forEach(sb::appendLine)

    System.out.bufferedWriter().append(sb).flush()
}

private fun BufferedReader.nextInt() = readLine().toInt()