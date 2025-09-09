package solved_ac.bronze.`2`

/**
 * **문제**
 * 욱제는 준원이랑 끝말잇기를 하고 있다. 준원이가 시작하자마자 '스트론튬'을 외쳐서 욱제는 피가 거꾸로 솟았다
 *
 * 준원이와의 끝말잇기 대결에서 패배한 욱제는 새로운 게임을 제안했다.
 *
 * 바로 팰린드롬 문자열만 사용할 수 있는 팰린드롬 끝말잇기이다! 욱제와 준원이는 총 N개의 팰린드롬 문자열 S1 .. SN을 알고 있다.
 *
 * 이 둘이 알고 있는 팰린드롬 문자열을 남김 없이 모두 사용했을 때, 끝말잇기를 할 수 있는지 알아보자. 문자열을 사용하는 순서는 상관 없다.
 *
 * "리효리", "찰진 의사의 진찰", "탄도유도탄"과 같이 앞으로 읽으나 뒤로 읽으나 똑같은 문자열을 팰린드롬 문자열이라고 부른다.
 *
 * **입력**
 * - 첫째 줄에 문자열의 개수 N이 주어진다.
 * - 둘째 줄에 N개의 팰린드롬 문자열 S<sub>i</sub> .. S<sub>n</sub>이 하나의 공백을 사이에 두고 주어진다.
 * - 1 <= N <= 100
 * - 1 <= Sᵢ 1<= 100
 * - Sᵢ는 알파벳 소문자로만 구성된 팰린드롬 문자열이다.
 *
 * **출력**
 * - 주어진 팰린드롬 문자열을 모두 사용했을 때 끝말잇기를 할 수 있으면 1, 그렇지 않다면 0을 출력한다.
 *
 * @see <a href="https://www.acmicpc.net/problem/20528">끝말잇기</a>
 * */
fun main() {
    readln()
    val strings = readln().split(" ")

    val firstChar = strings.first().first()
    if (!strings.all { it.first() == firstChar }){
        return println(0)
    }

    val result = strings.all { string ->
        val length = string.length
        for (i in 0..length / 2) {
            if (string[i] == string[length - 1 - i]) continue

            return@all false
        }
        true
    }

    println(if (result) 1 else 0)
}
