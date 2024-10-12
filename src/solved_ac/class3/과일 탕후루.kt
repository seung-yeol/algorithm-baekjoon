package solved_ac.class3

import java.io.BufferedReader
import kotlin.math.max

/**
 * **문제**
 * - 은하는 긴 막대에 N개의 과일이 꽂혀있는 과일 탕후루를 만들었습니다.
 * - 과일의 각 종류에는 1부터 9까지의 번호가 붙어있고, 앞쪽부터 차례로 S1, S2, ..., SN번 과일이 꽂혀있습니다.
 * - 과일 탕후루를 다 만든 은하가 주문을 다시 확인해보니 과일을 두 종류 이하로 사용해달라는 요청이 있었습니다.
 *
 * - 탕후루를 다시 만들 시간이 없었던 은하는, 막대의 앞쪽과 뒤쪽에서 몇 개의 과일을 빼서 두 종류 이하의 과일만 남기기로 했습니다.
 * - 앞에서 a개, 뒤에서 b개의 과일을 빼면 $Sa+1, Sa+2, ..., Sn-b-1, Sn-b번 과일, 총 N-a-b개가 꽂혀있는 탕후루가 됩니다.
 *
 * - 이렇게 만들 수 있는 과일을 두 종류 이하로 사용한 탕후루 중에서, 과일의 개수가 가장 많은 탕후루의 과일 개수를 구하세요.
 *
 * **입력**
 * - 첫 줄에 과일의 개수 N(1 <= N <= 200,000)이 주어집니다.
 * - 둘째 줄에 탕후루에 꽂힌 과일을 의미하는 N개의 정수 S1, S2, ..., SN(1 <= Si <= 9)이 공백으로 구분되어 주어집니다.
 *
 * **출력**
 * - 문제의 방법대로 만들 수 있는 과일을 두 종류 이하로 사용한 탕후루 중에서, 과일의 개수가 가장 많은 탕후루의 과일 개수를 첫째 줄에 출력하세요.
 *
 * @see <a href="https://www.acmicpc.net/problem/30804">과일 탕후루</a>
 * */
fun main() {
    val bufferedReader = System.`in`.bufferedReader().also { readln() }
    val ints = bufferedReader.nextInts()

    var answer = 0
    var startIndex = 0
    while (answer < ints.size - startIndex) {
        val (count, nextIndex) = ints.count(startIndex)
        answer = max(answer, count)

        if (nextIndex == startIndex) break

        startIndex = nextIndex
    }

    println(answer)
}

private fun IntArray.count(startIndex: Int): Pair<Int, Int> {
    var previous = 0
    var current = this[startIndex]
    var currentStartIndex = startIndex
    var count = 1

    for (index in startIndex + 1..lastIndex) {
        val value = this[index]
        if (current == value) {
            count++
            continue
        }

        if (previous == value || previous == 0) {
            count++

            previous = current
            current = value
            currentStartIndex = index
            continue
        }

        return count to currentStartIndex
    }

    return count to currentStartIndex
}

private fun BufferedReader.nextInts(): IntArray = readLine().split(" ").map(String::toInt).toIntArray()
