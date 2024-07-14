package solved_ac.class1

/**
 * @see <a href="https://www.acmicpc.net/problem/2884">알람 시계</a>
 *
 * "45분 일찍 알람 설정하기"이다.
 *
 * 원래 설정되어 있는 알람을 45분 앞서는 시간으로 바꾸는 것이다.
 * 현재 상근이가 설정한 알람 시각이 주어졌을 때, 이를 언제로 고쳐야 하는지 구하는 프로그램을 작성하시오.
 *
 * 첫째 줄에 두 정수 H와 M이 주어진다. (0 ≤ H ≤ 23, 0 ≤ M ≤ 59)
 * 24시간 표현에서 하루의 시작은 0:0(자정)이고, 끝은 23:59(다음날 자정 1분 전)이다.
 * 시간을 나타낼 때, 불필요한 0은 사용하지 않는다.
 * */
fun main() {
    var (h, m) = System.`in`.bufferedReader().readLine()
        .split(" ")
        .let { it.first().toInt() to it.last().toInt() }
    m -= 45

    if (m < 0) {
        if (h == 0) h = 23 else h--
        m += 60
    }
    println("$h $m")
}