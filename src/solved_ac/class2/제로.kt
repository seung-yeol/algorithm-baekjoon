package solved_ac.class2

import java.util.*

/**
 * @see <a href="https://www.acmicpc.net/problem/10773">제로</a>
 *
 * 재현이는 잘못된 수를 부를 때마다 0을 외쳐서, 가장 최근에 재민이가 쓴 수를 지우게 시킨다.
 * 재민이는 이렇게 모든 수를 받아 적은 후 그 수의 합을 알고 싶어 한다. 재민이를 도와주자!
 *
 * 첫 번째 줄에 정수 K가 주어진다. (1 ≤ K ≤ 100,000)
 *
 * 이후 K개의 줄에 정수가 1개씩 주어진다. 정수는 0에서 1,000,000 사이의 값을 가지며, 정수가 "0" 일 경우에는 가장 최근에 쓴 수를 지우고, 아닐 경우 해당 수를 쓴다.
 *
 * 정수가 "0"일 경우에 지울 수 있는 수가 있음을 보장할 수 있다.
 * */
fun main() {
    val buff = System.`in`.bufferedReader()
    val scanner = Scanner(buff)

    val stack = Stack<Int>()
    repeat(scanner.nextInt()) {
        val number = scanner.nextInt()
        if (number == 0) {
            stack.pop()
            return@repeat
        }

        stack.push(number)
    }

    println(stack.sum())
}
