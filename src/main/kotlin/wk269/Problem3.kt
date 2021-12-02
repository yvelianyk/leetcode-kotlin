package wk269

import kotlin.math.min

fun main() {
    val result = Problem3().minimumDeletions(intArrayOf(1, 2))
    println(result)
}

class Problem3 {
    fun minimumDeletions(nums: IntArray): Int {
        // Find indices of min and max elements
        var minIndex = 0
        var maxIndex = 0
        for ((index, num) in nums.withIndex()) {
            if (num > nums[maxIndex]) maxIndex = index
            if (num < nums[minIndex]) minIndex = index
        }

        // Find in what order min and max elements appear in the array
        val first = if (minIndex < maxIndex) minIndex else maxIndex
        val second = if (minIndex > maxIndex) minIndex else maxIndex

        // There are 3 cases when we can remove 2 elements:

        // 1. Remove all elements from the first appeared element to the right.
        // It will include both elements in any case:
        //   _   _
        // 2,1,3,6,5
        //  |_______
        val removeLessToTheLeft = first + 1

        // 2. Remove all elements from the second appeared element to the left.
        // It will include both elements in any case:
        //   _   _
        // 2,1,3,6,5
        // _______|
        val removeLessToTheRight = nums.size - first

        // 3. Remove all elements from the first to the left
        // and from the second to the right
        //   _   _
        // 2,1,3,6,5
        // ___| |___
        val removeBiggerToTheLeft = second + 1
        val removeBiggerToTheRight = nums.size - second

        // Then just find the minimum between all 3 cases:
        return min(
            removeLessToTheLeft + removeBiggerToTheRight,
            min(removeLessToTheRight, removeBiggerToTheLeft)
        )
    }
}