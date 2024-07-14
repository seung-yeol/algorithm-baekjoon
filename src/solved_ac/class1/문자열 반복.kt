package solved_ac.class1

/**
 * @see <a href="https://www.acmicpc.net/problem/2675">문자열 반복</a>
 *
 * 문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오.
 * 즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다.
 * S에는 QR Code "alphanumeric" 문자만 들어있다.
 *
 * QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.
 * */
fun main() {
    val buffer = System.`in`.bufferedReader()
    val count = buffer.readLine().toInt()
    val stringBuilder = StringBuilder()

    repeat(count) {
        val (repeatCount, string) = buffer.readLine().split(" ").let { it.first().toInt() to it.last() }
        string.writeRepeatedly(repeatCount, stringBuilder)
    }
    println(stringBuilder)
}

private fun String.writeRepeatedly(repeatCount: Int, to: StringBuilder) {
    forEach { char -> repeat(repeatCount) { to.append(char) } }
    to.appendLine()
}