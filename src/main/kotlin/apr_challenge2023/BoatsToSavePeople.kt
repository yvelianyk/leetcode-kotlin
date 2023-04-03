package apr_challenge2023

import java.util.*

fun main() {
    val res = BoatsToSavePeople().numRescueBoats(intArrayOf(3,2,2,1), 3)
    println(res)
}


class BoatsToSavePeople {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        val countMap = TreeMap<Int, Int>()
        var result = 0
        for (p in people) countMap[p] = countMap.getOrDefault(p, 0) + 1
        while (countMap.isNotEmpty()) {
            val smaller = countMap.firstKey()
            if (countMap[smaller] == 1) {
                countMap.remove(smaller)
            } else {
                countMap[smaller] = countMap[smaller]!! - 1
            }
            val remain = limit - smaller
            val floor = countMap.floorKey(remain)
            floor?.let {
                if (countMap[floor] == 1) {
                    countMap.remove(floor)
                } else {
                    countMap[floor] = countMap[floor]!! - 1
                }
            }
            result++
        }
        return result
    }
}