package solved_ac.class3

import java.io.BufferedReader
import kotlin.math.max

/**
 * **문제** :
 *
 * 계단 오르기 게임은 계단 아래 시작점부터 계단 꼭대기에 위치한 도착점까지 가는 게임이다.
 *
 * 예를 들어 아래의 그림과 같이 시작점에서부터 첫 번째, 두 번째, 네 번째, 여섯 번째 계단을 밟아 도착점에 도달하면 총 점수는 10 + 20 + 25 + 20 = 75점이 된다.
 *
 * 계단 오르는 데는 다음과 같은 규칙이 있다.
 *
 * 1. 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
 *
 * 2. 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
 *
 * 3. 마지막 도착 계단은 반드시 밟아야 한다.
 *
 * 각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성하시오.
 *
 * **입력** :
 *
 * 입력의 첫째 줄에 계단의 개수가 주어진다. 둘째 줄부터 한 줄에 하나씩 제일 아래에 놓인 계단부터 순서대로 각 계단에 쓰여 있는 점수가 주어진다.
 *
 * 계단의 개수는 300이하의 자연수이고, 계단에 쓰여 있는 점수는 10,000이하의 자연수이다.
 *
 * **출력** :
 *
 * 첫째 줄에 계단 오르기 게임에서 얻을 수 있는 총 점수의 최댓값을 출력한다.
 *
 * @see <img src="https://u.acmicpc.net/f00b6121-1c25-492e-9bc0-d96377c586b0/Screen%20Shot%202021-06-23%20at%203.01.39%20PM.png"/>
 *
 * @see <a href="https://www.acmicpc.net/problem/2579">계단 오르기</a>
 * */
fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val stairs = IntArray(bufferedReader.nextInt())
    repeat(stairs.size) { stairs[it] = bufferedReader.nextInt() }

    val score = Climber(stairs).climb()
    println(score)
}

private fun BufferedReader.nextInt() = readLine().toInt()

private class Climber(private val stairs: IntArray) {
    private val memo: Array<Pair<Int, Int>> = Array(stairs.size) { Int.MIN_VALUE to Int.MIN_VALUE }

    fun climb(): Int = max(
        goUp(score = 0, index = 0, isOneStep = false),
        goUp(score = 0, index = 1, isOneStep = false),
    )

    private fun goUp(score: Int, index: Int, isOneStep: Boolean): Int {
        if (index > stairs.lastIndex) return Int.MIN_VALUE

        val newScore = updateMemo(score, index, isOneStep) ?: return Int.MIN_VALUE
        if (index == stairs.lastIndex) return newScore

        if (isOneStep) return goUp(newScore, index + 2, false)

        return max(
            goUp(newScore, index + 1, true),
            goUp(newScore, index + 2, false)
        )
    }

    private fun updateMemo(score: Int, index: Int, isOneStep: Boolean): Int? {
        val newScore = score + stairs[index]

        if (isOneStep) {
            if (memo[index].first < newScore) {
                memo[index] = memo[index].copy(first = newScore)
                return newScore
            }
        }

        if (memo[index].second < newScore) {
            memo[index] = memo[index].copy(second = newScore)
            return newScore
        }

        return null
    }
}
