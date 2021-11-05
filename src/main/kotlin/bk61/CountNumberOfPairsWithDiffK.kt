package bk61

import kotlin.math.abs

class CountNumberOfPairsWithDiffK {
    fun countKDifference(nums: IntArray, k: Int): Int {
        var count = 0
        for (i in nums.indices) {
            for (j in i until nums.size) {
                if (abs(nums[i] - nums[j]) == k) count++
            }
        }
        return count
    }
}
