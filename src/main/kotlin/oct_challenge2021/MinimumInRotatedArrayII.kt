package oct_challenge2021

// Binary search approach
// If right element value is less than middle
// it means that minimum element will be always in the part of the array
// between mid and right indices because it's rotated.

fun main() {
    val array = intArrayOf(4, 5, 6, 7, 0)
    val result = MinimumInRotatedArrayII().findMin(array)
    println(result)
}

class MinimumInRotatedArrayII {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right: Int = nums.lastIndex
        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            if (nums[right] < nums[mid])
                left = mid
            else if (nums[right] > nums[mid])
                right = mid
            else right--
        }

        return minOf(nums[left], nums[right])
    }
}
