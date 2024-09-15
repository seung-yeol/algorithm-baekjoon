package solved_ac.class3

/**
 * **문제** : 첫째 줄에는 도감에 수록되어 있는 포켓몬의 개수 N이랑 내가 맞춰야 하는 문제의 개수 M이 주어져.
 *
 * N과 M은 1보다 크거나 같고, 100,000보다 작거나 같은 자연수이다.
 *
 * 둘째 줄부터 N개의 줄에 포켓몬의 번호가 1번인 포켓몬부터 N번에 해당하는 포켓몬까지 한 줄에 하나씩 입력으로 들어와.
 *
 * 그 다음 줄부터 총 M개의 줄에 내가 맞춰야하는 문제가 입력으로 들어와.
 *
 * 문제가 알파벳으로만 들어오면 포켓몬 번호를 말해야 하고, 숫자로만 들어오면, 포켓몬 번호에 해당하는 문자를 출력해야해.
 *
 * 입력으로 들어오는 숫자는 반드시 1보다 크거나 같고, N보다 작거나 같고, 입력으로 들어오는 문자는 반드시 도감에 있는 포켓몬의 이름만 주어져.
 *
 * **출력** : 첫째 줄부터 차례대로 M개의 줄에 각각의 문제에 대한 답을 말해줬으면 좋겠어.
 * 입력으로 숫자가 들어왔다면 그 숫자에 해당하는 포켓몬의 이름을, 문자가 들어왔으면 그 포켓몬의 이름에 해당하는 번호를 출력하면 돼.
 *
 * @see <a href="https://www.acmicpc.net/problem/1620">나는야 포켓몬 마스터 이다솜</a>
 * */
fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val stringBuilder = StringBuilder()
    val (count, problem) = bufferedReader.readLine().split(" ").map(String::toInt)
    val nameHashMap = hashMapOf<String, Int>()
    val nameList = mutableListOf("")

    repeat(count) {
        val name = bufferedReader.readLine()
        nameHashMap[name] = it + 1
        nameList.add(name)
    }
    repeat(problem) {
        val line = bufferedReader.readLine()
        val number = line.toIntOrNull() ?: run {
            // nameList.indexOf(line) 하면 O(n)이어서 시간초과 발생. HashMap을 사용하여 O(1)로 품.
            stringBuilder.appendLine(nameHashMap[line])
            return@repeat
        }

        val name = nameList[number]
        stringBuilder.appendLine(name)
    }

    println(stringBuilder)
}
