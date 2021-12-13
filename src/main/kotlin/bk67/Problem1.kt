package bk67

fun main() {
    val arr = intArrayOf(3,4,3,3)
    val result = Problem1().maxSubsequence(arr, 2)
    println(result)
}

class Problem1 {
    fun maxSubsequence(nums: IntArray, k: Int): IntArray {
        val arr = nums.toMutableList()
        arr.sort()
        val map = mutableMapOf<Int, Int>()
        for (i in nums.size - 1 downTo nums.size - k) {
            val current = map.getOrDefault(arr[i], 0)
            map[arr[i]] = current + 1
        }
        val listRes = mutableListOf<Int>()
        var count2 = 0
        for (num in nums) {
            val current = map.getOrDefault(num, 0)
            if (current > 0 && count2 < k) {
                listRes.add(num)
                count2++
            }
            map[num] = current - 1
        }
        return listRes.toIntArray()
    }


}