package solved_ac.class2

/**
 * @see <a href="https://www.acmicpc.net/problem/15829">해싱</a>
 * */

private const val R = 31
private const val M = 1234567891

fun main() {
    readln()
    val string = readln()
    val hash = string.withIndex().sumOf { (index, char) ->
        val start = 'a'.code - 1
        val code = char.code - start
        val poweredR = (1..index).fold(1L) { acc, _ -> acc.xRmodM() }

        code * poweredR % M
    } % M

    println(hash.toLong())
}

fun Long.xRmodM(): Long = this * R % M