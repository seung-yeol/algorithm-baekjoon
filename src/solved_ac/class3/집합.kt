package solved_ac.class3

import java.io.BufferedReader

/**
 * **문제** : 비어있는 공집합 S가 주어졌을 때, 아래 연산을 수행하는 프로그램을 작성하시오.
 *
 * add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
 *
 * remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
 *
 * check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
 *
 * toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
 *
 * all: S를 {1, 2, ..., 20} 으로 바꾼다.
 *
 * empty: S를 공집합으로 바꾼다.
 *
 * **입력** : 첫째 줄에 수행해야 하는 연산의 수 M (1 ≤ M ≤ 3,000,000)이 주어진다.
 * 둘째 줄부터 M개의 줄에 수행해야 하는 연산이 한 줄에 하나씩 주어진다.
 *
 * **출력** : check 연산이 주어질때마다, 결과를 출력한다.
 *
 * @see <a href="https://www.acmicpc.net/problem/11723">집합</a>
 * */
fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val count = bufferedReader.nextInt()
    val set = mutableSetOf<Int>()
    val fullSet = IntArray(20) { it + 1 }.toTypedArray()
    val stringBuilder = StringBuilder()


    repeat(count) {
        when (val command = Command.of(bufferedReader.readLine())) {
            is Command.Add -> set.add(command.x)
            is Command.Remove -> set.remove(command.x)
            is Command.Toggle -> if (!set.remove(command.x)) set.add(command.x)
            is Command.Check -> {
                val checked = if (set.contains(command.x)) 1 else 0
                stringBuilder.appendLine(checked)
            }

            Command.All -> set.addAll(fullSet)
            Command.Empty -> set.clear()
        }
    }

    println(stringBuilder)
}

private fun BufferedReader.nextInt() = readLine().toInt()

private enum class CommandType(val code: String) {
    Add("add"),
    Remove("remove"),
    Check("check"),
    Toggle("toggle"),
    All("all"),
    Empty("empty");
}

private sealed interface Command {
    data class Add(val x: Int) : Command
    data class Remove(val x: Int) : Command
    data class Check(val x: Int) : Command
    data class Toggle(val x: Int) : Command
    data object All : Command
    data object Empty : Command

    companion object {
        fun of(line: String): Command {
            val separated = line.split(" ")
            val commandString = separated.first()
            val commandType = CommandType.entries.first { it.code == commandString }
            return when (commandType) {
                CommandType.Add -> Add(separated[1].toInt())
                CommandType.Remove -> Remove(separated[1].toInt())
                CommandType.Check -> Check(separated[1].toInt())
                CommandType.Toggle -> Toggle(separated[1].toInt())
                CommandType.All -> All
                CommandType.Empty -> Empty
            }
        }
    }
}