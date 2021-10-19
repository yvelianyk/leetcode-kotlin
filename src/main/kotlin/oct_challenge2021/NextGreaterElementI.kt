package oct_challenge2021

fun main() {
    val result = NextGreaterElementI().nextGreaterElement(intArrayOf(4, 1, 2), intArrayOf(1, 3, 4, 2))
    println(result)
}

// could be solved more efficiently
class NextGreaterElementI {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val map2 = mutableMapOf<Int, Int>()
        val result = IntArray(nums1.size)
        for (i in nums2.indices) map2[nums2[i]] = i
        for (i in nums1.indices) {
            val higherIndex = map2[nums1[i]]
            result[i] = -1
            for (index in higherIndex!! until nums2.size) {
                if (nums2[index] > nums1[i]) {
                    result[i] = nums2[index]
                    break
                }
            }
        }
        return result
    }
}
