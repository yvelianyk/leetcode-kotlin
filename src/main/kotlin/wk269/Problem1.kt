package wk269

class Problem1 {
    fun targetIndices(nums: IntArray, target: Int): List<Int> {
        nums.sort()
        val result = mutableListOf<Int>()
        for ((index,num) in nums.withIndex()) {
            if (num == target) result.add(index)
        }
        return result
    }
}
