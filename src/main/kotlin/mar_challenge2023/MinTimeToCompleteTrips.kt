package mar_challenge2023

fun main() {
    val res = MinTimeToCompleteTrips().minimumTime(intArrayOf(1, 1, 2, 5), 10)
//    val res = MinTimeToCompleteTrips().minimumTime(intArrayOf(2), 1)
    println(res)
}

class MinTimeToCompleteTrips {
    fun minimumTime(time: IntArray, totalTrips: Int): Long {
        var maxTime = time.maxOrNull()!! * totalTrips.toLong()
        var minTime = 0L
        while (minTime < maxTime) {
            val mid = minTime + (maxTime - minTime) / 2
            val possibleTrips = time.sumOf { mid / it }
            if (possibleTrips < totalTrips) minTime = mid + 1 else maxTime = mid
        }
        return minTime
    }
}