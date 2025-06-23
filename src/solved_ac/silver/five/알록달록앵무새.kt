package solved_ac.silver.five

/**
 * **문제**
 * 재현이가 키우는 앵무새 포포와 레몬이는 그동안 새끼들을 참 많이도 낳았다.
 *
 * 그렇게 태어난 앵무새들을 관찰하며 재현이는 앵무새들의 색에 간단한 규칙이 있다는 것을 발견했다.
 *
 * 자식 앵무새의 몸통 색은 아빠새의 몸통색과 꼬리색, 엄마새의 몸통색과 꼬리색 중 하나이며 꼬리색도 마찬가지로 이 넷 중 하나의 색으로 정해진다는 것이다.
 *
 * 아빠새의 몸통색과 꼬리색, 엄마새의 몸통색과 꼬리색이 주어질 때 가능한 자식 앵무새의 몸통 색과 꼬리색의 모든 쌍을 사전 순으로 출력하라.
 * (단, 중복되는 몸통 색, 꼬리색의 쌍은 출력하지 않는다.)
 *
 * **입력**
 * - 첫 번째 줄에 아빠 새의 몸통 색과 꼬리 색이 주어진다.
 * - 두 번째 줄에 엄마 새의 몸통 색과 꼬리 색이 주어진다.
 * - 각각의 색은 1자 이상 20자 이내의 알파벳 소문자로 이루어진 문자열로 주어지며, 같은 색이 중복되어 나타날 수 있다.
 *
 * **출력**
 * - 자식 새의 몸통 색과 꼬리 색의 쌍을 한 줄에 하나씩 사전 순으로 출력한다.
 * - 사전 순으로 출력하라는 말은 몸통 색이 다르다면 몸통 색의 사전 순으로, 몸통 색이 같다면 꼬리 색의 사전 순으로 출력하라는 것을 의미한다.
 *
 * @see <a href="https://www.acmicpc.net/problem/28445">알록달록 앵무새</a>
 * */
fun main() {
    val stringBuilder = StringBuilder()
    val (fatherBody, fatherTail) = readln().split(" ")
    val (motherBody, motherTail) = readln().split(" ")
    val sortedSet = sortedSetOf(fatherBody, fatherTail, motherBody, motherTail)
    sortedSet.forEach { body ->
        sortedSet.forEach { tail ->
            stringBuilder.appendLine("$body $tail")
        }
    }

    println(stringBuilder.toString())
}
