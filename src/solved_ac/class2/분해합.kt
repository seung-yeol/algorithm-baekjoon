package solved_ac.class2

/**
 * @see <a href="https://www.acmicpc.net/problem/2231">분해합</a>
 *
 * 어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다.
 * 어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다. 예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다.
 * 따라서 245는 256의 생성자가 된다. 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다.
 * 반대로, 생성자가 여러 개인 자연수도 있을 수 있다.
 *
 * 자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.
 *
 * 예제 : 216
 * 답 : 198
 * */
fun main() {
    val number = readln().toInt()
    var answer = 0
    for (i in number downTo 0) {
        val separated = i.toString().map(Char::digitToInt)
        if (i + separated.sum() == number) answer = i

        /* 불필요한 loop skip */
        if (i == number - separated.size * 9) break
    }

    println(answer)
}