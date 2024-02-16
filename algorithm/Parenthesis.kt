package algorithm

/*
* https://www.acmicpc.net/problem/9012
* */
fun main() {
    System.`in`.bufferedReader()
        .also { it.readLine() }
        .forEachLine(::solve)
}

private fun solve(input: String) {
    var sum = 0
    input.forEach {
        if (it == '(') sum++ else sum--
        if (sum == -1) return println("NO")
    }

    if (sum != 0) return println("NO")

    println("YES")
}
