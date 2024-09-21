package solved_ac.class3

import java.io.BufferedReader

/**
 * **문제** :
 *
 * 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.
 *
 * **입력** :
 * 1. 첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다.
 * 2. 둘째 줄에는 N개의 수가 주어진다. 수는 1,000보다 작거나 같은 자연수이다.
 * 3. 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.
 *
 * **출력** :
 *
 * 총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.
 *
 * @see <a href="https://www.acmicpc.net/problem/11659"></a>
 * */
fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val (_, questionCount) = bufferedReader.nextInts()
    val sums = listOf(0) + bufferedReader.nextInts().runningReduce { acc, new -> acc + new }
    val stringBuilder = StringBuilder()

    repeat(questionCount) {
        val (start, end) = bufferedReader.nextInts()
        stringBuilder.appendLine(sums[end] - sums[start - 1])
    }

    println(stringBuilder)
}

private fun BufferedReader.nextInts(): IntArray = readLine().split(" ").map(String::toInt).toIntArray()
