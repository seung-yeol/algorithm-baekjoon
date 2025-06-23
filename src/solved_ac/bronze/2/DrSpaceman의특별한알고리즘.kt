package solved_ac.bronze.`2`

/**
 * **문제**
 * 아빠 키에 엄마 키를 더하고, 남자아이는, 5인치를 더하고, 여자아이는, 5인치를 뺍니다.
 *
 * 2로 나누면 윤곽이 보입니다.
 *
 * Dr. Spaceman은 4인치를 가감하면 아이 키의 범위가 나온다고 한다.
 *
 * **입력**
 * - 입력의 첫째 줄에는 테스트 케이스의 개수를 의미하는 T가 주어진다. 그 뒤에는 T개의 라인이 입력된다.
 *
 * - 각 라인은 알파벳 한 글자('B'는 남자아이(boy), 'G'는 여자아이(girl))와 공백 한 칸, 엄마의 키, 공백 한 칸, 아빠의 키가 주어집니다.
 *
 * - 키는 피트, 작은따옴표('), 인치, 큰따옴표(")로 이루어지며, 피트(feet)는 양의 정수이고, 인치(inch)는 음이 아닌 정수입니다.
 *
 * - 1 ≤ T ≤ 6000.
 * - 입력되는 피트의 숫자는 1 과 9 이내의 숫자이다.
 * - 입력되는 인치의 숫자는 0 과 11 이내의 숫자이다.
 *
 * **출력**
 * - 각각의 테스트 케이스에 대해 "Case #x: A to B"의 형식으로 출력한다.
 *
 * - x는 (1부터 시작하는) 케이스의 번호를, A와 B에는 각각 아이의 키의 최솟값/최댓값을 Dr. Spaceman의 알고리즘에 따라 출력한다.
 *
 * - 만약 결과가 인치 단위에서 정수가 되지 않을 경우, 구간의 양 끝 값을 안쪽으로 조여(shrink) 정수 범위로 만들어 출력해야 합니다.
 *
 * @see <a href="https://www.acmicpc.net/problem/12353">Dr.Spaceman의 특별한 알고리즘</a>
 * */
fun main() {
    val count = readln().toInt()
    val stringBuilder = StringBuilder()

    repeat(count) {
        val times = it + 1
        val (gender, man, woman) = readln().split(" ")
        val (manFt, manInch) = man.split("'", "\"").take(2).map(String::toInt)
        val (womanFt, womanInch) = woman.split("'", "\"").take(2).map(String::toInt)

        val childFt = manFt + womanFt
        val asInch = childFt * 12 + manInch + womanInch + (if (gender == "B") 5 else -5)
        val childInch = asInch / 2.toFloat()

        val startInch = (childInch + 0.5f).toInt() - 4
        val endInch = childInch.toInt() + 4

        val start = "${startInch / 12}'${startInch % 12}\""
        val end = "${endInch / 12}'${endInch % 12}\""

        stringBuilder.appendLine("Case #$times: $start to $end")
    }

    println(stringBuilder.toString())
}
