package solved_ac.class3

/**
 * **문제**
 * - 루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.
 *
 * **입력**
 * - 첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.
 *
 * **출력**
 * - 첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.
 *
 * @see <a href="https://www.acmicpc.net/problem/11725">트리의 부모 찾기</a>
 * */
fun main() {
    val n = readln().toInt()
    val map = mutableMapOf<Int, MutableList<Int>>()

    repeat(n - 1) {
        val (x, y) = readln().split(" ").map(String::toInt)

        map.getOrPut(x) { mutableListOf() }.add(y)
        map.getOrPut(y) { mutableListOf() }.add(x)
    }

    // key = child, value = parent
    val nodes = mutableMapOf<Int, Int>()

    val parents = mutableListOf(1)
    while (parents.isNotEmpty()) {
        val parent = parents.removeFirst()
        val childs = map[parent].orEmpty()

        for (child in childs) {
            if (nodes.contains(child)) continue
            nodes[child] = parent
            parents.add(child)
        }
    }

    val stringBuilder = StringBuilder()
    for (i in 2..n) stringBuilder.appendLine(nodes[i])

    println(stringBuilder.toString())
}
