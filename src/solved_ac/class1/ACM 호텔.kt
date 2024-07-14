package solved_ac.class1

/**
 * @see <a href="https://www.acmicpc.net/problem/10250">ACM 호텔</a>
 *
 * 문제설명 너무 김
 * */
fun main() {
    val buffer = System.`in`.bufferedReader()
    val count = buffer.readLine().toInt()
    val stringBuilder = StringBuilder()
    repeat(count) {
        val (height, order) = buffer.readLine().split(" ").let { it.first().toInt() to it.last().toInt() }
        var floor = order % height
        var number = order / height + 1

        if (floor == 0) {
            floor = height
            number--
        }

        stringBuilder.appendLine("$floor${String.format("%02d", number)}")
    }
    println(stringBuilder)
}