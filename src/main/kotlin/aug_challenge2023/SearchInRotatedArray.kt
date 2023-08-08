package aug_challenge2023

fun main() {
    val res = SearchInRotatedArray().search(
        intArrayOf(3,1),
        1
    )
    println(res)
}

class SearchInRotatedArray {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex
        while (left <= right) {
            val pivot = left + (right - left) / 2
            if (nums[pivot] == target) return pivot
            if (nums[left] == target) return left
            if (nums[right] == target) return right
            // check where is the sorted part of the array
            if (nums[pivot] > nums[left]) {
                // left part is sorted
                // if target within sorted part then reduce size of the search
                // if not - move to the rotated part
                if (target < nums[pivot] && target > nums[left]) {
                    right = pivot - 1
                } else {
                    left = pivot + 1
                }
            } else {
                // right part is sorted
                if (target > nums[pivot] && target < nums[right]) {
                    left = pivot + 1
                } else {
                    right = pivot - 1
                }
            }
        }
        return -1
    }
}