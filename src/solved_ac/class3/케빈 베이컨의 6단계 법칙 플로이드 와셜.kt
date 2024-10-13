package solved_ac.class3

import java.io.BufferedReader
import kotlin.math.min

/**
 * **문제**
 * - 케빈 베이컨의 6단계 법칙에 의하면 지구에 있는 모든 사람들은 최대 6단계 이내에서 서로 아는 사람으로 연결될 수 있다.
 * - 케빈 베이컨 게임은 임의의 두 사람이 최소 몇 단계 만에 이어질 수 있는지 계산하는 게임이다.
 * - 케빈 베이컨은 미국 헐리우드 영화배우들 끼리 케빈 베이컨 게임을 했을때 나오는 단계의 총 합이 가장 적은 사람이라고 한다.
 * - 유저 중에서 케빈 베이컨의 수가 가장 작은 사람을 찾으려고 한다.
 * - 케빈 베이컨 수는 모든 사람과 케빈 베이컨 게임을 했을 때, 나오는 단계의 합이다.
 * - BOJ 유저의 수와 친구 관계가 입력으로 주어졌을 때, 케빈 베이컨의 수가 가장 작은 사람을 구하는 프로그램을 작성하시오.
 *
 * **예시**
 * - BOJ의 유저가 5명이고, 1과 3, 1과 4, 2와 3, 3과 4, 4와 5가 친구인 경우를 생각해보자.
 * - 1은 2까지 3을 통해 2단계 만에, 3까지 1단계, 4까지 1단계, 5까지 4를 통해서 2단계 만에 알 수 있다. 따라서, 케빈 베이컨의 수는 2+1+1+2 = 6이다.
 * - 2는 1까지 3을 통해서 2단계 만에, 3까지 1단계 만에, 4까지 3을 통해서 2단계 만에, 5까지 3과 4를 통해서 3단계 만에 알 수 있다. 따라서, 케빈 베이컨의 수는 2+1+2+3 = 8이다.
 * - 3은 1까지 1단계, 2까지 1단계, 4까지 1단계, 5까지 4를 통해 2단계 만에 알 수 있다. 따라서, 케빈 베이컨의 수는 1+1+1+2 = 5이다.
 * - 4는 1까지 1단계, 2까지 3을 통해 2단계, 3까지 1단계, 5까지 1단계 만에 알 수 있다. 4의 케빈 베이컨의 수는 1+2+1+1 = 5가 된다.
 * - 5는 1까지 4를 통해 2단계, 2까지 4와 3을 통해 3단계, 3까지 4를 통해 2단계, 4까지 1단계 만에 알 수 있다. 5의 케빈 베이컨의 수는 2+3+2+1 = 8이다.
 * - 5명의 유저 중에서 케빈 베이컨의 수가 가장 작은 사람은 3과 4이다.
 *
 * **입력**
 * - 첫째 줄에 유저의 수 N (2 ≤ N ≤ 100)과 친구 관계의 수 M (1 ≤ M ≤ 5,000)이 주어진다.
 * - 둘째 줄부터 M개의 줄에는 친구 관계가 주어진다. 친구 관계는 중복되어 들어올 수도 있으며, 친구가 한 명도 없는 사람은 없다.
 * - 또, 모든 사람은 친구 관계로 연결되어져 있다.
 * - 사람의 번호는 1부터 N까지이며, 두 사람이 같은 번호를 갖는 경우는 없다.
 *
 * **출력**
 * - 첫째 줄에 BOJ의 유저 중에서 케빈 베이컨의 수가 가장 작은 사람을 출력한다. 그런 사람이 여러 명일 경우에는 번호가 가장 작은 사람을 출력한다.
 *
 * @see <a href="https://www.acmicpc.net/problem/1389">케빈 베이컨의 6단계 법칙</a>
 * */
fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val (count, line) = bufferedReader.nextInts()
    val connections = Array(count + 1) { IntArray(count + 1) { 101 } }

    repeat(line) {
        val (a, b) = bufferedReader.nextInts()
        connections[a][b] = 1
        connections[b][a] = 1
    }

    val solver = Q1389_FloydWarshell(connections)
    println(solver.answer())
}

private class Q1389_FloydWarshell(val connections: Array<IntArray>) {
    fun answer(): Int {
        run()

        var min = Int.MAX_VALUE
        var answer = 0

        for ((index, connected) in connections.withIndex().drop(1)) {
            val kevinBacon = connected.sum()
            if (min <= kevinBacon) continue

            min = kevinBacon
            answer = index
        }

        return answer
    }

    private fun run() {
        for (stopover in 1..connections.lastIndex) {
            for (start in 1..connections.lastIndex) {
                for (destination in 1..connections.lastIndex) {
                    if (stopover == start || stopover == destination) continue

                    connections[start][destination] = min(
                        connections[start][destination],
                        connections[start][stopover] + connections[stopover][destination]
                    )
                }
            }
        }
    }
}

private fun BufferedReader.nextInts(): IntArray = readLine().split(" ").map(String::toInt).toIntArray()
