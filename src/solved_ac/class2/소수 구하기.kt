package solved_ac.class2

/**
 * @see <a href="https://www.acmicpc.net/problem/1929">소수 구하기</a>
 *
 * M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
 *
 * 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다.
 * (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
 *
 * 한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
 * */
fun main() {
    val (m, n) = readln().split(" ").map(String::toInt)
    val primeNumbers = mutableListOf(2)
    val stringBuilder = StringBuilder()

    for (i in 3..n step 2) {
        var isPrime = true
        for (primeNumber in primeNumbers) {
            if (i < primeNumber * primeNumber) break
            if (i % primeNumber == 0) {
                isPrime = false
                break
            }
        }

        if (isPrime) primeNumbers.add(i)
    }

    primeNumbers.dropWhile { it < m }.forEach(stringBuilder::appendLine)
    println(stringBuilder)
}
