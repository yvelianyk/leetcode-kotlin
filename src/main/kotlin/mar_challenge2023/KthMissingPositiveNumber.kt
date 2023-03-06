package mar_challenge2023

fun main() {
    val arr = intArrayOf(1,2,3,4)
    val res = KthMissingPositiveNumber().findKthPositive(arr, 2)
    println(res)
}

class KthMissingPositiveNumber {
    fun findKthPositive(arr: IntArray, k: Int): Int {
        val set = arr.toHashSet()
        var count = 1
        var i = 1

        while (count <= k) {
            if (!set.contains(i)) {
                if (count++ == k) {
                    return i
                }
            }
            i++
        }

        return 0
    }
}