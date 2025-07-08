package solved_ac.silver.two

import kotlin.math.max

/**
 * **문제**
 *
 * 이제 세준이가 병원에 입원한 동안 자기를 생각해준 사람들에게 감사하다고 말할 차례이다.
 * - 세준이를 생각해준 사람은 총 N명이 있다.
 * - 사람의 번호는 1번부터 N번까지 있다.
 * - 세준이가 i번 사람에게 인사를 하면 L[i]만큼의 체력을 잃고, J[i]만큼의 기쁨을 얻는다.
 * - 세준이는 각각의 사람에게 최대 1번만 말할 수 있다.
 * - 세준이의 목표는 주어진 체력내에서 최대한의 기쁨을 느끼는 것이다.
 * - 세준이의 체력은 100이고, 기쁨은 0이다.
 * - 만약 세준이의 체력이 0이나 음수가 되면, 죽어서 아무런 기쁨을 못 느낀 것이 된다.
 * - 세준이가 얻을 수 있는 최대 기쁨을 출력하는 프로그램을 작성하시오.
 *
 * **입력**
 * - 첫째 줄에 사람의 수 N(≤ 20)이 들어온다.
 * - 둘째 줄에는 각각의 사람에게 인사를 할 때, 잃는 체력이 1번 사람부터 순서대로 들어오고,
 * - 셋째 줄에는 각각의 사람에게 인사를 할 때, 얻는 기쁨이 1번 사람부터 순서대로 들어온다.
 * - 체력과 기쁨은 100보다 작거나 같은 자연수 또는 0이다.
 *
 * **출력**
 * - 첫째 줄에 세준이가 얻을 수 있는 최대 기쁨을 출력한다.
 *
 * @see <a href="https://www.acmicpc.net/problem/1535">안녕</a>
 * */
fun main() {
    val mans = readln().toInt()
    val health = readln().split(" ").map(String::toInt)
    val happiness = readln().split(" ").map(String::toInt)

    println(Q1535(mans, health, happiness).solve())
}

private class Q1535(
    val mans: Int,
    val health: List<Int>,
    val happiness: List<Int>
) {
    private var maxValue = 0

    fun solve(): Int {
        next(0, 100, 0)
        return maxValue
    }

    private fun next(value: Int, remainHealth: Int, index: Int) {
        if (index == mans) return

        next(value, remainHealth, index + 1)

        val newHealth = remainHealth - health[index]
        if (newHealth <= 0) return

        val newValue = value + happiness[index]
        maxValue = max(maxValue, newValue)
        next(newValue, newHealth, index + 1)
    }
}
