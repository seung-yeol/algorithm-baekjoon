package src.solved_ac.class2

import java.util.*

/**
 * @see <a href="https://www.acmicpc.net/problem/30802">웰컴키트</a>
 *
 * 티셔츠는 S, M, L, XL, XXL, 그리고 XXXL의 6가지 사이즈가 있습니다.
 * 티셔츠는 같은 사이즈의 t장 묶음으로만 주문할 수 있습니다.
 * 펜은 한 종류로, p자루씩 묶음으로 주문하거나 한 자루씩 주문할 수 있습니다.
 * 총 n명의 참가자 중 S, M, L, XL, XXL, XXXL 사이즈의 티셔츠를 신청한 사람은 각각 S, M, L, XL, XXL, XXXL 명입니다.
 * 티셔츠는 남아도 되지만 부족해서는 안 되고 신청한 사이즈대로 나눠주어야 합니다.
 * 펜은 남거나 부족해서는 안 되고 정확히 참가자 수만큼 준비되어야 합니다.
 *
 * 첫 줄에 참가자의 수 n이 주어집니다.
 * 둘째 줄에 티셔츠 사이즈별 신청자의 수 S, M, L, XL, XXL, XXXL이 공백으로 구분되어 주어집니다.
 * 셋째 줄에 정수 티셔츠와 펜의 묶음 수를 의미하는 정수 t와 p가 공백으로 구분되어 주어집니다.
 *
 * 첫 줄에 티셔츠를 t장씩 최소 몇 묶음 주문해야 하는지 출력하세요.
 * 다음 줄에 펜을 p자루씩 최대 몇 묶음 주문할 수 있는지와, 그 때 펜을 한 자루씩 몇 개 주문하는지 구하세요.
 *
 * 23
 * 3 1 4 1 5 9
 * 5 7
 *
 * 7
 * 3 2
 * */
fun main() {
    val buffer = System.`in`.bufferedReader()
    val scanner = Scanner(buffer)

    val participants = scanner.nextInt()
    val s = scanner.nextInt()
    val m = scanner.nextInt()
    val l = scanner.nextInt()
    val xl = scanner.nextInt()
    val xxl = scanner.nextInt()
    val xxxl = scanner.nextInt()
    val t = scanner.nextInt()
    val p = scanner.nextInt()

    val bundleCount = calculateBundleCount(s, m, l, xl, xxl, xxxl, divider = t)
    val pencilBundle = participants / p
    val pencilPiece = participants % p
    println(bundleCount)
    println("$pencilBundle $pencilPiece")
}

private fun calculateBundleCount(vararg sizes: Int, divider: Int): Int =
    sizes.sumOf { it.calculateBundleCount(divider) }

private fun Int.calculateBundleCount(divider: Int): Int =
    (this / divider).let { if (this % divider != 0) it + 1 else it }