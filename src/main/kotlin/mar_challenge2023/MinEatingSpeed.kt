package mar_challenge2023

fun main() {
//    val res = MinEatingSpeed().minEatingSpeed(intArrayOf(3,6,7,11), 8)
    val res = MinEatingSpeed().minEatingSpeed(intArrayOf(30,11,23,4,20), 6)
    println(res)
}

class MinEatingSpeed {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var left = 1
        var right = piles.maxOrNull()!!
        while (left < right) {
            val mid = left + (right - left) / 2
            val hoursToEat = piles.sumOf { (it - 1) / mid + 1 }
            if (hoursToEat > h) left = mid + 1 else right = mid
        }
        return left
    }
}