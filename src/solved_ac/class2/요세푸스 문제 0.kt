package solved_ac.class2

/**
 * @see <a href="https://www.acmicpc.net/problem/11866">요세푸스 문제 0</a>
 *
 * 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
 * 이제 순서대로 K번째 사람을 제거한다.
 * 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다.
 * 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
 * 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다.
 * 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
 *
 * 첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 1,000)
 *
 * 입력
 * 7 3
 *
 * 출력
 * <3, 6, 2, 7, 5, 1, 4>
 * */
fun main() {
    val (n, k) = readln().split(" ").map(String::toInt)

    val sb = StringBuilder().append("<")
    val list = Array(n) { it + 1 }.toMutableList()

    var currentIndex = 0
    while (list.size >= 2) {
        currentIndex = (currentIndex + k - 1) % list.size
        val item = list.removeAt(currentIndex)
        sb.append(item).append(", ")
    }
    sb.append(list[0]).append(">")

    println(sb)
}