package nov_challenge2021

fun main() {
    val result = MinimumValueStepSum().minStartValue(intArrayOf(1,-2,-3))
    assert(result == 5)
}

class MinimumValueStepSum {
    fun minStartValue(nums: IntArray): Int {
        val prefixSums = IntArray(nums.size)
        prefixSums[0] = nums[0]
        for (i in 1 until nums.size) {
            prefixSums[i] = prefixSums[i - 1] + nums[i]
        }
        val min = prefixSums.minOrNull()
        return if (min!! >= 0) 1 else 1 - min
    }
}
