package solved_ac.bronze.`1`

/**
 * **문제**
 * 준하는 유치원에서 단어 퍼즐게임을 즐겨한다.
 *
 * 단어 퍼즐게임이란, 주어진 알파벳들을 섞어서 단어를 만드는 게임이다.
 *
 * 천재 준하는 알파벳을 임의로 조합하여, 사전과 매칭된 단어를 만드는 프로그램을 만들어 단어를 완성시켰다.
 *
 * 그러나 완성된 단어를 원장님에게 가져가려는 순간, 지나가던 강민이와 부딫혀서 단어조각을 땅에 떨어뜨리고 말았다.
 *
 * 준하는 어찌어찌 조각을 회수했지만, 순서는 뒤죽박죽이 되었고, 알파벳이 부족하거나 다른 알파벳이 섞였을 수도 있다.
 *
 * 준하가 처음에 완성한 단어와 나중에 회수한 알파벳들이 주어질 때, 준하가 알파벳을 제대로 회수했는지 안했는지 판단하는 프로그램을 만들어주자.
 *
 * **입력**
 * - 입력은 케이스마다 두줄로 이루어져있다.
 * - 첫째 줄은 준하가 처음 완성한 단어이고, 둘째 줄은 떨어뜨린 다음 회수한 알파벳들이다.
 * - 각 줄은 알파벳 소문자로 이루어져 있고, 길이는 1000을 넘지 않는다.
 * - 마지막에 END라는 단어가 두줄 주어지는데, 이는 케이스의 끝을 의미한다.
 *
 * **출력**
 * - 케이스마다 번호를 붙여서 예제출력과 같은 형식으로 출력한다.
 *
 * 준하가 알파벳을 제대로 회수했다면 same 을, 잘못 회수했다면 different 를 출력한다.
 *
 * @see <a href="https://www.acmicpc.net/problem/9946">단어 퍼즐</a>
 * */
fun main() {
    val stringBuilder = StringBuilder()
    var count = 0
    while (true) {
        count++
        val ordered = readln()
        val mixed = readln()
        if (ordered == mixed && ordered == "END") break

        if (ordered.length != mixed.length) {
            stringBuilder.appendLine("Case $count: different")
            continue
        }

        val map = mutableMapOf<Char, Int>()
        for (c in ordered) map[c] = map.getOrPut(c) { 0 } + 1

        for (c in mixed) {
            val result = map.getOrPut(c) { 0 } - 1
            if (result < 0) break

            map[c] = result
        }

        val result = if (map.values.all { it == 0 }) "same" else "different"
        stringBuilder.appendLine("Case $count: $result")
    }

    println(stringBuilder.toString())
}
