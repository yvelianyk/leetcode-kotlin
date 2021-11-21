package nov_challenge2021

fun main() {
    val result = SingleElementInSortedArray().singleNonDuplicate(intArrayOf(1, 1, 2, 3, 3, 4, 4, 8, 8))
    println(result)
}

class SingleElementInSortedArray {
    fun singleNonDuplicate(nums: IntArray): Int {
        var left = 0
        var right = nums.lastIndex
        while (left < right) {
            val mid = left + (right - left) / 2
            val isEven = (right - mid) % 2 == 0
            when {
                nums[mid] == nums[mid - 1] -> if (isEven) right = mid - 2 else left = mid + 1
                nums[mid] == nums[mid + 1] -> if (isEven) left = mid + 2 else right = mid - 1
                else -> return nums[mid]
            }
        }
        return nums[left]
    }
}
