package src.solved_ac.class1

/**
 *@see <a href="https://www.acmicpc.net/problem/2439"></a>
 *
 * 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
 * 하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.
 *
 * 5
 *     *
 *    **
 *   ***
 *  ****
 * *****
 *
 * */
fun main() {
    val count = System.`in`.bufferedReader().readLine().toInt()
    val result = StringBuilder()

    for (i in (1..count)) {
        repeat(count - i) { result.append(" ") }
        repeat(i) { result.append("*") }
        result.appendLine()
    }
    println(result)
}