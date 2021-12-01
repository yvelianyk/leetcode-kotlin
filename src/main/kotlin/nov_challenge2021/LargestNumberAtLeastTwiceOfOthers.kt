package nov_challenge2021

fun main() {
    val result = LargestNumberAtLeastTwiceOfOthers().dominantIndex(intArrayOf(1,0))
    println(result)
}

class LargestNumberAtLeastTwiceOfOthers {
    fun dominantIndex(nums: IntArray): Int {
        if (nums.size == 1) return 0
        var first = Int.MIN_VALUE
        var second = Int.MIN_VALUE
        var firstIndex = 0
        for ((index, num) in nums.withIndex()) {
            if (num > first) {
                second = first
                first = num
                firstIndex = index
            }
            if (num in (second + 1) until first) second = num
        }
        return if (first >= (second * 2)) firstIndex else -1
    }
}
