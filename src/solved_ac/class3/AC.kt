package solved_ac.class3

/**
 * **문제**
 * - 선영이는 정수 배열에 연산을 하기 위해 새로운 언어 AC를 만들었다.
 * - 함수 R은 배열에 있는 수의 순서를 뒤집는 함수이고, D는 첫 번째 수를 버리는 함수이다.
 * - 배열이 비어있는데 D를 사용한 경우에는 에러가 발생한다.
 * - 함수는 조합해서 한 번에 사용할 수 있다.
 * - 예를 들어, "AB"는 A를 수행한 다음에 바로 이어서 B를 수행하는 함수이다.
 * - 예를 들어, "RDD"는 배열을 뒤집은 다음 처음 두 수를 버리는 함수이다.
 * - 배열의 초기값과 수행할 함수가 주어졌을 때, 최종 결과를 구하는 프로그램을 작성하시오.
 *
 * **입력**
 * - 첫째 줄에 테스트 케이스의 개수 T가 주어진다. T는 최대 100이다.
 * - 각 테스트 케이스의 첫째 줄에는 수행할 함수 p가 주어진다. p의 길이는 1보다 크거나 같고, 100,000보다 작거나 같다.
 * - 다음 줄에는 배열에 들어있는 수의 개수 n이 주어진다. (0 ≤ n ≤ 100,000)
 * - 다음 줄에는 [x1,...,xn]과 같은 형태로 배열에 들어있는 정수가 주어진다. (1 ≤ xi ≤ 100)
 * - 전체 테스트 케이스에 주어지는 p의 길이의 합과 n의 합은 70만을 넘지 않는다.
 *
 * **출력**
 * - 각 테스트 케이스에 대해서, 입력으로 주어진 정수 배열에 함수를 수행한 결과를 출력한다. 만약, 에러가 발생한 경우에는 error를 출력한다.
 *
 * @see <a href="https://www.acmicpc.net/problem/5430">AC</a>
 * */

private val bufferedReader = System.`in`.bufferedReader()

fun main() {
    val stringBuilder = StringBuilder()
    val questionCount = bufferedReader.readLine().toInt()

    repeat(questionCount) {
        val methods = bufferedReader.readLine().toCharArray()
        stringBuilder.appendLine(solve(methods))
    }

    println(stringBuilder)
}

private fun solve(methods: CharArray): String {
    var isForward = true
    var forward = 0
    var backward = 0
    methods.forEach {
        if (it == 'R') {
            isForward = !isForward
            return@forEach
        }

        if (isForward) forward++ else backward++
    }

    val arrayCount = bufferedReader.readLine().toInt()
    val arrayString = bufferedReader.readLine()
    if (arrayCount < forward + backward) return "error"

    val ints = IntArray(arrayCount)
    arrayString.drop(1).dropLast(1)
        .split(",")
        .filter { it.isNotEmpty() }
        .forEachIndexed { index, int -> ints[index] = int.toInt() }

    val stringBuilder = StringBuilder().append("[")
    val sliced = ints.sliceArray(forward..<arrayCount - backward)
    sliced.apply { if (isForward) return@apply else reverse() }
        .forEach(stringBuilder::append)

    return sliced.joinToString(",", prefix = "[", postfix = "]")
}