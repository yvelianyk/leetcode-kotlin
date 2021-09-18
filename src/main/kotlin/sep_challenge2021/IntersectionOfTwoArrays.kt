package sep_challenge2021

fun main() {
//    val arr1 = intArrayOf(1,2,2,1)
//    val arr2 = intArrayOf(2,2)
    val arr1 = intArrayOf(4,9,5)
    val arr2 = intArrayOf(9,4,9,8,4)
    val intersect = intersect(arr1, arr2)
    println(intersect)
}

fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val map = mutableMapOf<Int,Int>()
    for (i in nums2) map[i] = map.getOrDefault(i, 0) + 1
    val result = mutableListOf<Int>()
    for (i in nums1) {
        val count = map.getOrDefault(i, 0)
        if (count > 0) {
            result.add(i)
            map[i] = map.getOrDefault(i, 0) - 1
        }
    }
    return result.toIntArray()
}