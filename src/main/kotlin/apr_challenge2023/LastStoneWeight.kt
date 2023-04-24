package apr_challenge2023

import java.util.*
import kotlin.math.abs

fun main() {
    val res = LastStoneWeight().lastStoneWeight(intArrayOf(1,1))
    println(res)
}

class LastStoneWeight {
    fun lastStoneWeight(stones: IntArray): Int {
        val queue = PriorityQueue<Int> { a, b -> b - a}
        queue.addAll(stones.toList())
        while (queue.size >= 1) {
            val last = queue.poll()
            if (queue.isNotEmpty()) {
                val beforeLast = queue.poll()
                queue.add(abs(last-beforeLast))
            } else {
                return last
            }
        }
        return 0
    }
}