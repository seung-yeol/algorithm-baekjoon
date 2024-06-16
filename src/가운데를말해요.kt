import java.util.*

/**
 * @see <a href="https://www.acmicpc.net/problem/1655">가운데를 말해요</a>
 *
 * 백준이가 정수를 하나씩 외칠때마다 동생은 지금까지 백준이가 말한 수 중에서 중간값을 말해야 한다.
 * 만약, 그동안 백준이가 외친 수의 개수가 짝수개라면 중간에 있는 두 수 중에서 작은 수를 말해야 한다.
 * 예를 들어 백준이가 동생에게 1, 5, 2, 10, -99, 7, 5를 순서대로 외쳤다고 하면, 동생은 1, 1, 2, 2, 2, 2, 5를 차례대로 말해야 한다.
 * 백준이가 외치는 수가 주어졌을 때, 동생이 말해야 하는 수를 구하는 프로그램을 작성하시오.
 *
 * 첫째 줄에는 백준이가 외치는 정수의 개수 N이 주어진다. N은 1보다 크거나 같고, 100,000보다 작거나 같은 자연수이다.
 * 그 다음 N줄에 걸쳐서 백준이가 외치는 정수가 차례대로 주어진다. 정수는 -10,000보다 크거나 같고, 10,000보다 작거나 같다.
 * */
fun main() {
    val result = StringBuilder()
    val buffer = System.`in`.bufferedReader()
    val count = buffer.readLine().toInt()

    val maxCapacity = count / 2 + 1
    val leftQueue = PriorityQueue<Int>(maxCapacity, reverseOrder())
    val rightQueue = PriorityQueue<Int>(maxCapacity)

    buffer.lineSequence()
        .take(count)
        .map(String::toInt)
        .onEach { input ->
            if (leftQueue.size == 0) return@onEach run { leftQueue.add(input) }

            if (leftQueue.size == rightQueue.size) {
                if (input <= rightQueue.peek()) return@onEach run { leftQueue.add(input) }

                leftQueue.add(rightQueue.poll())
                rightQueue.add(input)
            } else {
                if (leftQueue.peek() < input) return@onEach run { rightQueue.add(input) }

                rightQueue.add(leftQueue.poll())
                leftQueue.add(input)
            }
        }
        .forEach { _ -> result.appendLine(leftQueue.peek()) }
    println(result)
}
