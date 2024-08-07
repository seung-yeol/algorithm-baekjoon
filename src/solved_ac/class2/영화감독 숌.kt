package solved_ac.class2

/**
 * @see <a href="https://www.acmicpc.net/problem/1436">영화감독 숌</a>
 *
 * 종말의 수란 어떤 수에 6이 적어도 3개 이상 연속으로 들어가는 수를 말한다.
 * 제일 작은 종말의 수는 666이고, 그 다음으로 큰 수는 1666, 2666, 3666, .... 이다.
 * 따라서, 숌은 첫 번째 영화의 제목은 "세상의 종말 666", 두 번째 영화의 제목은 "세상의 종말 1666"와 같이 이름을 지을 것이다.
 * 일반화해서 생각하면, N번째 영화의 제목은 세상의 종말 (N번째로 작은 종말의 수) 와 같다.
 *
 * 숌이 만든 N번째 영화의 제목에 들어간 수를 출력하는 프로그램을 작성하시오. 숌은 이 시리즈를 항상 차례대로 만들고, 다른 영화는 만들지 않는다.
 *
 * 첫째 줄에 N이 주어진다. N은 10,000보다 작거나 같은 자연수이다.
 * */
fun main() {
    val count = readln().toInt()
    var number = 666
    var i = 1
    while (i != count) {
        if (contain666(++number)) i++
    }

    println(number)
}

private fun contain666(n: Int): Boolean {
    var number = n
    while (number > 665) {
        if (number % 1000 == 666) return true

        number /= 10
    }
    return false
}
