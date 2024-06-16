package src.solved_ac.class1

/**
 * @see <a href="https://www.acmicpc.net/problem/10809">알파벳 찾기</a>
 *
 * 알파벳 소문자로만 이루어진 단어 S가 주어진다.
 * 각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.
 *
 * input: baekjoon
 *
 * output: 1 0 -1 -1 2 -1 -1 -1 -1 4 3 -1 -1 7 5 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
 * */
fun main() {
    val string = readln()
    val result = MutableList(26) { -1 }

    string.forEachIndexed { index, i -> result.setIfNegative(index = i - 'a', value = index) }
    result.joinToString(" ").let(::println)
}

private fun MutableList<Int>.setIfNegative(index: Int, value: Int) {
    if (get(index) == -1) set(index, value)
}