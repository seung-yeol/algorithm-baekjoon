package solved_ac.class1

/**
 * @see <a href="https://www.acmicpc.net/problem/8958">OX퀴즈</a>
 *
 * "OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. O는 문제를 맞은 것이고, X는 문제를 틀린 것이다.
 * 문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다. 예를 들어, 10번 문제의 점수는 3이 된다.
 *
 * "OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
 *
 * OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.
 * */
fun main() {
    val buffer = System.`in`.bufferedReader()
    val count = buffer.readLine().toInt()
    val stringBuilder = StringBuilder()

    repeat(count) {
        var weight = 0
        var sum = 0
        buffer.readLine().forEach {
            if (it == 'X') return@forEach run { weight = 0 }

            sum += ++weight
        }
        stringBuilder.appendLine(sum)
    }
    println(stringBuilder)
}