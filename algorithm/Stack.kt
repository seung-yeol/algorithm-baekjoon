package algorithm

/*
* https://www.acmicpc.net/problem/10828
* */

private const val POP: String = "pop"
private const val SIZE: String = "size"
private const val EMPTY: String = "empty"
private const val TOP: String = "top"

fun main() {
    val stack = mutableListOf<String>()
    System.`in`.bufferedReader()
        .also { it.readLine() }
        .forEachLine {
            when (it) {
                POP -> println(stack.removeLastOrNull() ?: "-1")
                SIZE -> println(stack.size.toString())
                EMPTY -> println(if (stack.isEmpty()) "1" else "0")
                TOP -> println(stack.lastOrNull() ?: "-1")
                else -> stack.add(it.findValue())
            }
        }
}

private fun String.findValue() = split(" ").last()