package solved_ac.silver.four

/**
 * **문제**
 * 윤이, 달구, 포닉스는 UDPC에 참가하는 여러분을 위해 클로버를 만들어 선물하기로 했다.
 *
 * 클로버는 줄기와 잎으로 이루어져 있으며, 하나의 줄기에 3개 또는 4개의 잎이 달려야 한다.
 *
 * 클로버 조립을 맡은 포닉스는 윤이로부터 A개의 클로버 줄기를, 달구로부터 B개의 클로버 잎을 받았다.
 *
 * 포닉스는 클로버를 조립하다 문득 이대로라면 쓰지 못한 줄기나 잎이 남을 수 있다는 사실을 깨닫고 말았다.
 *
 * 포닉스는 재료가 남는 것을 막기 위해 클로버 줄기 또는 잎을 더 가져오려 한다.
 *
 * 줄기와 잎을 남김없이 모두 써서 클로버를 만들기 위해 포닉스가 더 가져와야 하는 클로버 줄기와 잎 개수의 합의 최솟값을 구해주자.
 *
 * **입력**
 * - 첫째 줄에 테스트케이스의 개수 T(1 <= T <= 1000)가 주어진다.
 * - 둘째 줄부터 T줄에 걸쳐 클로버 줄기의 개수 A, 클로버 잎의 개수 B가 공백으로 구분되어 주어진다.
 * - 0 <= A,B <= 1000
 *
 * **출력**
 * - 각 테스트케이스에 대해 포닉스가 더 가져와야 하는 클로버 줄기와 잎 개수의 합의 최솟값을 한 줄에 하나씩 순서대로 출력한다.
 *
 * @see <a href="https://www.acmicpc.net/problem/14244">트리만들기</a>
 * */
fun main() {
    val stringBuilder = StringBuilder()
    val count = readln().toInt()

    for (i in 0 until count) {
        val (stem, leaf) = readln().split(" ").map(String::toInt)
        val minimumLeaf = stem * 3
        val maximumLeaf = stem * 4

        val more = if (leaf in minimumLeaf..maximumLeaf) {
            0
        } else if (leaf < minimumLeaf) {
            minimumLeaf - leaf
        } else {
            val remainLeaf = leaf - maximumLeaf
            val newFulledStem = remainLeaf / 4
            val fulledStem = stem + newFulledStem

            val newStem = newFulledStem + if (remainLeaf % 4 != 0) 1 else 0
            val newLeaf = when {
                remainLeaf % 4 == 0 || remainLeaf % 4 == 3 || 2 <= fulledStem -> 0
                else -> 3 - remainLeaf % 4 - fulledStem
            }
            newStem + newLeaf
        }
        stringBuilder.appendLine(more)
    }

    println(stringBuilder.toString())
}
