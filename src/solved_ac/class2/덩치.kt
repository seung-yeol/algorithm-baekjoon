package solved_ac.class2

import java.util.*

/**
 * @see <a href="https://www.acmicpc.net/problem/7568">벌집</a>
 *
 *  어떤 사람의 몸무게가 x kg이고 키가 y cm라면 이 사람의 덩치는 (x, y)로 표시된다.
 *  두 사람 A 와 B의 덩치가 각각 (x, y), (p, q)라고 할 때 x > p 그리고 y > q 이라면 우리는 A의 덩치가 B의 덩치보다 "더 크다"고 말한다.
 *
 *  그런데 서로 다른 덩치끼리 크기를 정할 수 없는 경우도 있다.
 *  예를 들어 두 사람 C와 D의 덩치가 각각 (45, 181), (55, 173)이라면 몸무게는 D가 C보다 더 무겁고,
 *  키는 C가 더 크므로, "덩치"로만 볼 때 C와 D는 누구도 상대방보다 더 크다고 말할 수 없다. (같은 덩치로 취급)
 *
 *  첫 줄에는 전체 사람의 수 N이 주어진다.
 *  그리고 이어지는 N개의 줄에는 각 사람의 몸무게와 키를 나타내는 양의 정수 x와 y가 하나의 공백을 두고 각각 나타난다.
 *
 *  입력에 나열된 사람의 덩치 등수를 구해서 그 순서대로 첫 줄에 출력해야 한다. 단, 각 덩치 등수는 공백문자로 분리되어야 한다.
 * */
fun main() {
    val buffer = System.`in`.bufferedReader()
    val scanner = Scanner(buffer)
    val count = scanner.nextInt()
    val people = mutableListOf<Pair<Int, Int>>()

    repeat(count) {
        val person = scanner.nextInt() to scanner.nextInt()
        people.add(person)
    }

    val answer = people.map { target ->
        1 + people.count { other ->
            target.first < other.first && target.second < other.second
        }
    }.joinToString(" ")

    println(answer)
}