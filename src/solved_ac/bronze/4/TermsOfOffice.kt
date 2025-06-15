package solved_ac.bronze.`4`

/**
 * **문제**
 * - In CS City, a mathematical place to live,
 * - the mayor is elected every 4 years,
 * - the treasurer is appointed every 2 years,
 * - the chief programmer is elected every 3 years,
 * - the dog-catcher is replaced every 5 years.
 *
 * This year, Year X, the newly elected mayor announced the appointment of the new treasurer,
 * a new dog-catcher and congratulated the chief programmer for winning the recent election.
 *
 * That is, all positions were changed over.
 * This is highly unusual. You will quantify how unusual this really is.
 *
 * Write a program that inputs the year
 * X and the future year
 * Y and lists all years between
 * X and Y inclusive when all positions change.
 *
 * @see <a href="https://www.acmicpc.net/problem/6888">TermsOfOffice</a>
 * */
fun main() {
    var x = readln().toInt()
    val y = readln().toInt()

    val years = mutableListOf(x)

    while (x <= y - 60) {
        x += 60
        years.add(x)
    }

    val stringBuilder = StringBuilder()
    years.forEach {
        stringBuilder.appendLine("All positions change in year $it")
    }
    println(stringBuilder.toString())
}