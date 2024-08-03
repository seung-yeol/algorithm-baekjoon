package solved_ac.class2

import kotlin.math.min

/**
 * @see <a href="https://www.acmicpc.net/problem/1676">팩토리얼 0의 개수</a>
 *
 * N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.
 *
 * 첫째 줄에 N이 주어진다.
 *
 * */
fun main() {
    val n = readln().toInt()

    if (n < 5) return println(0)

    val answer = n.count()
    println(answer)
}

fun Int.count(): Int {
    var two = 0
    var five = 0
    for (i in 1..this) {
        if (i % 2 != 0 && i % 5 != 0) continue

        two += i.find(2)
        five += i.find(5)
    }

    return min(two, five)
}

fun Int.find(divider: Int): Int {
    var tmp = this
    var count = 0
    while (tmp % divider == 0) {
        count++
        tmp /= divider
    }

    return count
}
