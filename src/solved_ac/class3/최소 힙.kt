package solved_ac.class3

import java.io.BufferedReader
import java.util.*

/**
 * **문제**
 * - 널리 잘 알려진 자료구조 중 최소 힙이 있다. 최소 힙을 이용하여 다음과 같은 연산을 지원하는 프로그램을 작성하시오.
 * 1. 배열에 자연수 x를 넣는다.
 * 2. 배열에서 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
 * - 프로그램은 처음에 비어있는 배열에서 시작하게 된다.
 *
 * **입력**
 * - 첫째 줄에 연산의 개수 N(1 ≤ N ≤ 100,000)이 주어진다.
 * - 다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다.
 * - 만약 x가 자연수라면 배열에 x라는 값을 넣는(추가하는) 연산이고, x가 0이라면 배열에서 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다.
 * - x는 231보다 작은 자연수 또는 0이고, 음의 정수는 입력으로 주어지지 않는다.
 *
 * **출력**
 * - 입력에서 0이 주어진 횟수만큼 답을 출력한다. 만약 배열이 비어 있는 경우인데 가장 작은 값을 출력하라고 한 경우에는 0을 출력하면 된다.
 *
 * @see <a href="https://www.acmicpc.net/problem/1927">최소 힙</a>
 * */
fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val n = bufferedReader.nextInt()
    val stringBuilder = StringBuilder()

    val priorityQueue = PriorityQueue<Int>()

    for (i in 0 until n) {
        val nextInt = bufferedReader.nextInt()
        if (nextInt == 0) {
            if (priorityQueue.isEmpty()) {
                stringBuilder.appendLine(0)
                continue
            }
            stringBuilder.appendLine(priorityQueue.poll())
            continue
        }

        priorityQueue.add(nextInt)
    }

    println(stringBuilder)
}

private fun BufferedReader.nextInt() = readLine().toInt()
