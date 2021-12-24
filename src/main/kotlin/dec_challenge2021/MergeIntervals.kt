package dec_challenge2021

fun main() {
    val arr = arrayOf(intArrayOf(2,6), intArrayOf(1,3), intArrayOf(8,10), intArrayOf(15,18))
//    val arr = arrayOf(intArrayOf(1,4), intArrayOf(2,3))
    val result = MergeIntervals().merge(arr)
    println(result)
}

class MergeIntervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        intervals.sortBy { it[0] }
        result.add(intervals[0])
        for (i in 1 until intervals.size) {
            val prev = result.last()
            val curr = intervals[i]
            if (prev[1] >= curr[0]) {
                result.removeAt(result.size - 1)
                result.add(intArrayOf(prev[0], maxOf(curr[1], prev[1])))
            } else {
                result.add(curr)
            }
        }
        return result.toTypedArray()
    }
}