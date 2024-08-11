package solved_ac.class2

/**
 * @see <a href="https://www.acmicpc.net/problem/2839">설탕 배달</a>
 *
 * 설탕공장에서 만드는 설탕은 봉지에 담겨져 있다. 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.
 * 최대한 적은 봉지를 들고 가려고 한다.
 * 예를 들어, 18킬로그램 설탕을 배달해야 할 때, 3킬로그램 봉지 6개를 가져가도 되지만,
 * 5킬로그램 3개와 3킬로그램 1개를 배달하면,더 적은 개수의 봉지를 배달할 수 있다.
 *
 * 설탕을 정확하게 N킬로그램 배달해야 할 때, 봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성하시오.
 * 만약, 정확하게 N킬로그램을 만들 수 없다면 -1을 출력한다.
 * */
fun main() {
    val weight = readln().toInt()

    var failCount = 0
    while (true) {
        val remainWeight = weight - 3 * failCount
        if (remainWeight < 0) return println(-1)

        val count = count(remainWeight)
        if (count != -1) return println(count + failCount)

        failCount++
    }
}

private fun count(weight: Int): Int {
    var tmpWeight = weight
    var count = 0
    while (5 <= tmpWeight) {
        tmpWeight -= 5
        count++
    }

    while (3 <= tmpWeight) {
        tmpWeight -= 3
        count++
    }

    return if (tmpWeight != 0) -1 else count
}