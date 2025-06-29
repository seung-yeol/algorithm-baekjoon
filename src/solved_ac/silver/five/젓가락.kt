package solved_ac.silver.five


/**
 * **문제**
 *
 * 젓가락통에 N종류의 젓가락이 종류별로 충분히 많이 들어있다.
 *
 * 당신은 이 젓가락통에서 무작위로 젓가락을 뽑아서 R개의 짝을 맞춰야 한다.
 *
 * 최악의 경우 몇 개의 젓가락을 뽑아야 하는가?
 *
 * **입력**
 * - 두 개의 정수 N, R이 주어진다. 1 ≤ N,R ≤ 10^18
 *
 * **출력**
 * - 최악의 경우 뽑아야 하는 젓가락의 개수를 출력한다.
 *
 * @see <a href="https://www.acmicpc.net/problem/24228">젓가락</a>
 * */
fun main() {
    val (n, r) = readln().split(" ").map(String::toLong)

    println(2 * r + n - 1)
}
