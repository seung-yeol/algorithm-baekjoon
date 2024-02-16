package algorithm

/*
* https://www.acmicpc.net/problem/9093
* */

fun main() {
    System.`in`.bufferedReader()
        .also { it.readLine() }
        .forEachLine(::solve)
}

private fun solve(input: String) {
    val words = input.split(" ").asSequence()
    val reversedWords = words.map(String::reversed)
    println(reversedWords.joinToString(" "))
}