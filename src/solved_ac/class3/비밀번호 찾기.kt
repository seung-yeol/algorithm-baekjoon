package solved_ac.class3

/**
 * **문제** :
 *
 * 경민이는 메모장에 사이트의 주소와 비밀번호를 저장해두기로 했다.
 *
 * 하지만 컴맹인 경민이는 메모장에서 찾기 기능을 활용하지 못하고 직접 눈으로 사이트의 주소와 비밀번호를 찾았다.
 *
 * 이를 딱하게 여긴 문석이는 경민이를 위해 메모장에서 비밀번호를 찾는 프로그램을 만들기로 결심하였다.
 *
 * **입력** :
 *
 * 첫째 줄에 저장된 사이트 주소의 수 N(1 ≤ N ≤ 100,000)과 비밀번호를 찾으려는 사이트 주소의 수 M(1 ≤ M ≤ 100,000)이 주어진다.
 *
 * 두번째 줄부터 N개의 줄에 걸쳐 각 줄에 사이트 주소와 비밀번호가 공백으로 구분되어 주어진다.
 *
 * 사이트 주소는 알파벳 소문자, 알파벳 대문자, 대시('-'), 마침표('.')로 이루어져 있고, 중복되지 않는다.
 *
 * 비밀번호는 알파벳 대문자로만 이루어져 있다. 모두 길이는 최대 20자이다.
 *
 * N+2번째 줄부터 M개의 줄에 걸쳐 비밀번호를 찾으려는 사이트 주소가 한줄에 하나씩 입력된다. 이때, 반드시 이미 저장된 사이트 주소가 입력된다.
 *
 * **출력** :
 *
 * 첫 번째 줄부터 M개의 줄에 걸쳐 비밀번호를 찾으려는 사이트 주소의 비밀번호를 차례대로 각 줄에 하나씩 출력한다.
 *
 * @see <a href="https://www.acmicpc.net/problem/17219">비밀번호 찾기</a>
 * */
fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val (n, required) = bufferedReader.readLine().split(" ").map(String::toInt)

    val passwordMap = hashMapOf<String, String>()
    repeat(n) {
        val (site, password) = bufferedReader.readLine().split(" ")
        passwordMap[site] = password
    }

    val stringBuilder = StringBuilder()
    repeat(required) {
        val site = bufferedReader.readLine()
        stringBuilder.appendLine(passwordMap[site])
    }

    println(stringBuilder)
}
