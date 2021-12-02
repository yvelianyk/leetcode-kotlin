package wk269

//
fun main() {
    val result = Problem2().getAverages(intArrayOf(7, 4, 3, 9, 1, 8, 5, 2, 6), 3)
//    val result = Problem2().getAverages(intArr, 10)
    println(result)
}

class Problem2 {
    fun getAverages(nums: IntArray, k: Int): IntArray {
        if (k * 2 > nums.size - 1) return IntArray(nums.size) { -1 }
        var initSum: Long = 0
        val result = IntArray(nums.size)

        for (index in 0..k * 2) {
            initSum += nums[index]
        }

        result[k] = (initSum / (k * 2 + 1)).toInt()

        for (index in nums.indices) {
            val prevIndex = index - 1 - k
            val nextIndex = index + k
            if (index == k) continue
            if (prevIndex < 0 || nextIndex >= nums.size) {
                result[index] = -1
                continue
            }
            val prev = nums[prevIndex]
            val next = nums[nextIndex]
            initSum = initSum - prev + next
            result[index] = (initSum / (k * 2 + 1)).toInt()
        }
        return result
    }
}
