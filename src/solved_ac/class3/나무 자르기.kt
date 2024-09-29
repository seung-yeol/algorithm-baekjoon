package solved_ac.class3

import java.io.BufferedReader

/**
 * **문제**
 * - 나무 M미터가 필요하다. 절단기에 높이 H를 지정해야 한다.
 * - 높이를 지정하면 톱날이 땅으로부터 H미터 위로 올라간다. 그 다음, 한 줄에 연속해있는 나무를 모두 절단해버린다.
 * - 높이가 H보다 큰 나무는 H 위의 부분이 잘릴 것이고, 낮은 나무는 잘리지 않을 것이다.
 * - 한 줄에 연속해있는 나무의 높이가 20, 15, 10, 17이라고 하자. 높이를 15로 지정했다면, 나무를 자른 뒤의 높이는 15, 15, 10, 15가 될 것이다.
 * - 상근이는 길이가 5인 나무와 2인 나무를 들고 집에 갈 것이다. (총 7미터를 집에 들고 간다) 절단기에 설정할 수 있는 높이는 양의 정수 또는 0이다.
 * - 나무를 필요한 만큼만 집으로 가져가려고 한다.
 * - 이때, 적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값을 구하는 프로그램을 작성하시오.
 *
 * **입력**
 * - 첫째 줄에 나무의 수 N과 집으로 가져가려고 하는 나무의 길이 M이 주어진다. (1 ≤ N ≤ 1,000,000, 1 ≤ M ≤ 2,000,000,000)
 * - 둘째 줄에는 나무의 높이가 주어진다. 나무의 높이의 합은 항상 M보다 크거나 같기 때문에, 상근이는 집에 필요한 나무를 항상 가져갈 수 있다.
 * - 높이는 1,000,000,000보다 작거나 같은 양의 정수 또는 0이다.
 *
 * **출력**
 * - 적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값을 출력한다.
 *
 * @see <a href="https://www.acmicpc.net/problem/2805">나무 자르기</a>
 * */
fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val (_, requiredLength) = bufferedReader.nextInts()
    val trees = bufferedReader.nextInts().apply { sortDescending() }

    val (index, acc) = trees.findTreeIndexWithAcc(requiredLength)
    val height = trees.findHeight(requiredLength, index, acc)

    println(height)
}

private fun BufferedReader.nextInts(): IntArray = readLine().split(" ").map(String::toInt).toIntArray()

private fun IntArray.findTreeIndexWithAcc(requireLength: Int): Pair<Int, Int> {
    var acc = 0

    for ((index, tree) in withIndex()) {
        val nextTree = if (index != lastIndex) this[index + 1] else 0

        val diff = (tree - nextTree) * (index + 1).toLong()
        if (requireLength <= acc + diff) return index to acc

        acc += diff.toInt()
    }

    return Int.MAX_VALUE to Int.MAX_VALUE
}

private fun IntArray.findHeight(requireLength: Int, treeIndex: Int, acc: Int): Int {
    var min = 0L
    var max = this[treeIndex].toLong() - (getOrNull(treeIndex + 1) ?: 0)
    var addedH = 0L

    while (true) {
        val current = acc + (treeIndex + 1) * addedH
        val previous = acc + (treeIndex + 1) * (addedH - 1)

        var isRequireNextStep = false
        if (current < requireLength) {
            isRequireNextStep = true
            min = addedH
        }

        if (requireLength <= previous) {
            isRequireNextStep = true
            max = addedH
        }

        if (isRequireNextStep) {
            // ex) min = 1, max = 2, addedH = 1 인 경우 무한루프에 빠지는 것을 회피
            // min = 1, max = 2, addedH = 2 인 경우는 isRequireNextStep이 true일 수 절대 없음
            addedH = (min + max) / 2 + (min + max) % 2
            continue
        }

        return this[treeIndex] - addedH.toInt()
    }
}
