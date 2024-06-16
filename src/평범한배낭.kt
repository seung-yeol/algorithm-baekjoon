import java.util.*

/**
 * https://www.acmicpc.net/problem/12865
 *
 * 준서가 여행에 필요하다고 생각하는 N개의 물건이 있다. 각 물건은 무게 W와 가치 V를 가지는데, 해당 물건을 배낭에 넣어서 가면 준서가 V만큼 즐길 수 있다.
 * 아직 행군을 해본 적이 없는 준서는 최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고 다닐 수 있다.
 * 준서가 최대한 즐거운 여행을 하기 위해 배낭에 넣을 수 있는 물건들의 가치의 최댓값을 알려주자.
 *
 * 첫 줄에 물품의 수 N(1 ≤ N ≤ 100)과 준서가 버틸 수 있는 무게 K(1 ≤ K ≤ 100,000)가 주어진다.
 * 두 번째 줄부터 N개의 줄에 거쳐 각 물건의 무게 W(1 ≤ W ≤ 100,000)와 해당 물건의 가치 V(0 ≤ V ≤ 1,000)가 주어진다.
 *
 * 입력으로 주어지는 모든 수는 정수이다.
 *
 * 4 7
 * 6 13
 * 4 8
 * 3 6
 * 2 5
 * 5 12
 * */
fun main() {
    var result = 0
    val buffer = System.`in`.bufferedReader()
    val (n, limit) = buffer.readLine().split(" ").run { get(0).toInt() to get(1).toInt() }

    val materials = mutableListOf<Material>()
    var i = 0
    while (i != n) {
        i++
        materials.add(buffer.readLine().toMaterial())
    }

    var (limitTmp, success) = shit(materials, limit)
    while (limitTmp != 0 || success.isEmpty()) {
        val newMaterial = materials - success
        shit(newMaterial, limitTmp + success.last().weight).also { (fi, se, thi) ->
            limitTmp = fi
            success = se
            if (result < thi) result = thi
        }
    }

    println(result)
}

private fun shit(materials: List<Material>, limit: Int): Triple<Int, List<Material>, Int> {
    val successs: MutableList<Material> = mutableListOf()
    val pq = PriorityQueue(materials)
    var resultTmp = 0
    var limitTmp = limit
    while (pq.isNotEmpty()) {
        val material = pq.poll()
        if (limitTmp < material.weight) continue

        successs.add(material)
        limitTmp -= material.weight
        resultTmp += material.value
    }
    return Triple(limitTmp, successs, resultTmp)
}

private fun String.toMaterial(): Material = split(" ").run { Material(get(0).toInt(), get(1).toInt()) }

private data class Material(val weight: Int, val value: Int) : Comparable<Material> {
    private val ratio: Float get() = value / weight.toFloat()

    override fun compareTo(other: Material): Int = when {
        ratio > other.ratio -> -1
        ratio == other.ratio -> if (weight < other.weight) -1 else 1
        else -> 1
    }
}

/**
 * 일단 무게에 따른 가치 정렬시키고
 *
 * 두배수를 넘어갈 수 없다.
 *
 *
 *
 * 무게정렬
 *
 *
 *
 * */