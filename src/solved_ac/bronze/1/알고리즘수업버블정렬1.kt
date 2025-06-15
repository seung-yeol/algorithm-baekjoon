package solved_ac.bronze.`1`

/**
 * **문제**
 * 오늘도 서준이는 버블 정렬 수업 조교를 하고 있다. 학생들이 잘 이해했는지 문제를 통해서 확인해보자.
 *
 * - N개의 서로 다른 양의 정수가 저장된 배열 A가 있다.
 * - 버블 정렬로 배열 A를 오름차순 정렬할 경우 K 번째 교환되는 수를 구해서 우리 서준이를 도와주자.
 *
 * 크기가 N인 배열에 대한 버블 정렬 의사 코드는 다음과 같다.
 * ```
 * bubble_sort(A[1..N]) { # A[1..N]을 오름차순 정렬한다.
 *     for last <- N downto 2
 *         for i <- 1 to last - 1
 *             if (A[i] > A[i + 1]) then A[i] <-> A[i + 1]  # 원소 교환
 * }
 * ```
 *
 * **입력**
 * - 첫째 줄에 배열 A의 크기 N(5 ≤ N ≤ 10,000), 교환 횟수 K(1 ≤ K ≤ N2)가 주어진다.
 *
 * - 다음 줄에 서로 다른 배열 A의 원소 A1, A2, ..., AN이 주어진다. (1 ≤ Ai ≤ 109)
 *
 * **출력**
 * - K 번째 교환되는 두 개의 수를 작은 수부터 한 줄에 출력한다. 교환 횟수가 K 보다 작으면 -1을 출력한다.
 *
 * @see <a href="https://www.acmicpc.net/problem/23968">알고리즘 수업 - 버블 정렬 1</a>
 * */
fun main() {
    val (_, k) = readln().split(" ").map(String::toInt)
    val ints = readln().split(" ").map(String::toInt).toIntArray()

    var events = 0
    var swapCount = 0
    while (events != ints.lastIndex) {
        for (i in 0..<ints.lastIndex - events) {
            if (ints[i] < ints[i + 1]) continue

            ints.swap(i, i + 1)
            swapCount++

            if (swapCount == k) println("${ints[i]} ${ints[i + 1]}")
        }

        events++
    }

    if (swapCount < k) println(-1)
}

private fun IntArray.swap(index1: Int, index2: Int) {
    val tmp = get(index1)
    set(index1, get(index2))
    set(index2, tmp)
}
