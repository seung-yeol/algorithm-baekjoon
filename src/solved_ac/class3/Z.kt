package solved_ac.class3

import kotlin.math.pow

/**
 * **문제**
 * - 한수는 크기가 2N × 2N인 2차원 배열을 Z모양으로 탐색하려고 한다.
 * - 예를 들어, 2×2배열을 왼쪽 위칸, 오른쪽 위칸, 왼쪽 아래칸, 오른쪽 아래칸 순서대로 방문하면 Z모양이다.
 * - N > 1인 경우, 배열을 크기가 2N-1 × 2N-1로 4등분 한 후에 재귀적으로 순서대로 방문한다.
 *
 * **입력**
 * - 첫째 줄에 정수 N, r, c가 주어진다.
 *
 * **출력**
 * - r행 c열을 몇 번째로 방문했는지 출력한다.
 *
 * @see <a href="https://www.acmicpc.net/problem/1074">Z</a>
 * */
fun main() {
    val (n, r, c) = readln().split(" ").map(String::toInt)

    println(solve(n, r, c))
}

/**
 * 전체 크기를 1 / 4씩 나눠가며 몇 분면의 위치하는지를 찾고, 지나온 분면에 대한 값(visited)들을 더함
 * */
fun solve(pow: Int, r: Int, c: Int): Int {
    val value = 2.0.pow((pow - 1).toDouble()).toInt()
    val row = r / value
    val column = c / value
    val count = when {
        row == 0 && column == 0 -> 0
        row == 0 && column == 1 -> 1
        row == 1 && column == 0 -> 2
        else -> 3
    }

    val visited = count * 4.0.pow((pow - 1).toDouble()).toInt()
    if (pow == 1) return visited

    return visited + solve(pow - 1, r % value, c % value)
}
