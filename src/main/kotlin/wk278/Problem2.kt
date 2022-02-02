package wk278

fun main() {
    val res = Problem2().maxScoreIndices(intArrayOf(0, 0, 1, 0))
    println(res)
}

class Problem2 {
    fun maxScoreIndices(nums: IntArray): List<Int> {
        val prefSum = IntArray(nums.size + 1)
        for (i in 1 until prefSum.size) prefSum[i] = nums[i - 1] + prefSum[i - 1]
        val result = mutableListOf<Int>()
        var max = Int.MIN_VALUE
        for (i in prefSum.indices) {
            val zeroSum = i - prefSum[i]
            val onesSum = prefSum[nums.size - 1] - prefSum[i]
            val score = zeroSum + onesSum
            if (score == max) result.add(i)
            if (score > max) {
                result.clear()
                result.add(i)
                max = score
            }
        }
        return result
    }
}
