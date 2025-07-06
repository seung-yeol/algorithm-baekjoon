package solved_ac.bronze.`1`

/**
 * **문제**
 *
 * 재우는 임관을 위해 최대 3개까지 수강할 수 있는 운동 과목을 수강하기로 했다.
 *
 * 작년에 F를 받은 “수영” 과목의 재수강은 물론, “축구”와 “볼링” 과목까지 최대로 수강하게 되었다.
 *
 * 재우의 정보를 보던 교수님께서는 재우가 세 과목 중 두 과목을 F를 받고 한 과목만 Pass를 받을 수 있다는 사실을 알게 되었다.
 *
 * 이제 재우는 다음과 같은 과정을 통해 정보를 얻을 수 있다.
 * - 재우가 Pass로 예상되는 과목 하나를 교수님께 말씀드린다.
 * - 교수님께서 재우에게 그 과목을 제외한 다른 두 과목 중 F를 받는 과목 하나를 알려주신다.
 * - 재우는 이 정보를 통해 두 과목을 드랍하고, 남은 한 과목을 수강하기로 하였다.
 * - 재우는 남은 한 과목이 Pass 받기를 원한다. 재우가 되어 그 과목을 찾아보자.
 *
 * 각 평행 세계에 대해 위의 1번과 2번 과정은 모두 다른 세계와 독립적으로 진행된다.
 * 1. 총 1500개의 독립적인 평행 세계가 존재해 각 평행 세계의 재우는 위의 결정을 해야 한다.
 * 2. 각각의 평행 세계에 대해 프로그램 시작 시 재우가 Pass를 받을 과목 하나가 독립적으로 1/3의 확률로 결정된다.
 *
 * 아래 인터랙티브 과정을 거쳐 1500개의 독립적인 평행 세계에 존재하는 재우 중 총 900명 이상의 최종적으로 예상한 과목이 프로그램이 정한 과목과 같아 재우가 Pass를 받았다면 정답이다.
 * 모든 평행 세계의 행동은 독립적으로 시행된다.
 *
 * **입력**
 * - 프로그램이 시작되면 먼저 평행 세계의 개수 n을 입력받는다.
 * - n개의 평행 세계에 대해 Pass로 예상되는 과목을 swimming, bowling, soccer 중 각각 하나씩 골라 한 줄에 공백으로 구분된 n개의 과목 이름을 출력한다.
 * - 그럼 프로그램은 각 평행 세계에 대해 고른 과목을 제외한 과목 두 개 중 F인 과목 이름을 하나씩 공백으로 구분하여 준다.
 * - 이 정보를 토대로 최종적으로 각 평행 세계에 대해 Pass로 예상되는 과목의 이름을 한 줄에 공백으로 구분하여 출력한다.
 *
 * @see <a href="https://www.acmicpc.net/problem/28682">재우야 임관하자</a>
 * */
fun main() {
    val subject = arrayOf("bowling", "swimming", "soccer")
    val count = readln().toInt()

    val expected = (0 until count)
        .map { (0..2).random().let { subject[it] } }

    println(expected.joinToString(" "))
    System.out.flush()

    val fails = readln().split(" ")
    val result = fails.mapIndexed { index, s ->
        val sub = subject.toMutableList()
        sub.remove(s)
        sub.remove(expected[index])
        sub.first()
    }.joinToString(" ")

    println(result)
    System.out.flush()
}
