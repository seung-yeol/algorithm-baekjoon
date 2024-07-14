package solved_ac.class1


/**
 * @see <a href="https://www.acmicpc.net/problem/2920">음계</a>
 *
 * 1부터 8까지 차례대로 연주한다면 ascending, 8부터 1까지 차례대로 연주한다면 descending, 둘 다 아니라면 mixed 이다.
 *
 * 연주한 순서가 주어졌을 때, 이것이 ascending인지, descending인지, 아니면 mixed인지 판별하는 프로그램을 작성하시오.
 * */
fun main() {
    val numbers = System.`in`.bufferedReader().readLine().split(" ").map(String::toInt)
    var isAscending = false
    var isDescending = false
    val isOrdered = numbers.withIndex().all { (index, value) ->
        when {
            index + 1 == value -> isAscending = true
            index + value == 8 -> isDescending = true
            else -> return@all false
        }
        isAscending.xor(isDescending)
    }

    if (!isOrdered) return println("mixed")
    if (isAscending) return println("ascending")
    if (isDescending) return println("descending")
}