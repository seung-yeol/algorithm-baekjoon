package solved_ac.bronze.`3`

/**
 * **문제**
 * - Today is Gabriel’s first day at his new job, and he has been given his first task.
 *
 * - He needs to read a string made up of uppercase letters from a file, sort the letters in the string alphabetically,
 * - filter out repeated letters, and then write the result back to the original file.
 *
 * - For instance, sorting the string “ICPC” would produce “CCIP”, which would become “CIP” after removing repeated letters. Easy, right?
 *
 * However, Gabriel made a tiny mistake. Instead of overwriting the file with the filtered string, he accidentally appended it to the file. Now, the file is corrupted, containing the original string followed by the sorted, duplicate-free version of it, and Gabriel is in a bit of a panic.
 *
 * Given the content of the corrupted file, can you determine the length of the original string? Gabriel is confident that with this information, he will be able to complete his assigned task.
 *
 * **입력**
 * The input consists of a single line that contains a string `S` made up of uppercase letters (2 ≤ |S| ≤ 2000),
 * which is the concatenation of the original (uncorrupted) string `t` and the sorted, duplicate-free version of `t`.
 *
 * **출력**
 * - Output a single line with an integer indicating the length of `t`.
 *
 * @see <a href="https://www.acmicpc.net/problem/33135">Append and Panic!</a>
 * */
fun main() {
    val string = readln()
    val sorted = string.toSortedSet()

    println(string.length - sorted.size)
}