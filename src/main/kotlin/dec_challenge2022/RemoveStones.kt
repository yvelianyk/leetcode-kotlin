package dec_challenge2022

import java.util.*


fun main() {
    val res = RemoveStones().minStoneSum(intArrayOf(10000), 10000)
    println(res)
}

class RemoveStones {
    fun minStoneSum(piles: IntArray, k: Int): Int {
        val queue = PriorityQueue<Int> { a, b -> b - a}
        var sum = piles.sum()
        for (pile in piles) queue.offer(pile)

        for (i in 1..k) {
            val num = queue.poll()
            queue.offer(num - num / 2)
            sum -= num / 2
        }

        return sum
    }
}