package may_challenge2023

fun main() {
//    val res = MaxUncrossedLines().maxUncrossedLines(
//        intArrayOf(1,4,2),
//        intArrayOf(1,2,4)
//    )
    val res = MaxUncrossedLines().maxUncrossedLines(
        intArrayOf(2, 5, 1, 2, 5),
        intArrayOf(10, 5, 2, 1, 5, 2)
    )
    println(res)
}

class MaxUncrossedLines {
    private lateinit var nums1: IntArray
    private lateinit var nums2: IntArray
    private lateinit var memo: Array<IntArray>
    fun maxUncrossedLines(nums1: IntArray, nums2: IntArray): Int {
        this.nums1 = nums1
        this.nums2 = nums2
        memo = Array(nums2.size) {
            IntArray(nums1.size) {
                -1
            }
        }
        return getMax(0, 0)
    }

    private fun getMax(j: Int, last: Int): Int {
        if (j == nums2.size || last == nums1.size) return 0
        if (memo[j][last] != -1) return memo[j][last]
        val num2 = nums2[j]
        val nextInt = getNextInt(last, num2)
        val res = if (nextInt != -1) {
            val max1 = 1 + getMax(j + 1, nextInt + 1)
            val max2 = getMax(j + 1, last)
            maxOf(max1, max2)
        } else {
            getMax(j + 1, last)
        }
        memo[j][last] = res
        return res
    }

    private fun getNextInt(i: Int, number: Int): Int {
        for (k in i until nums1.size) {
            if (nums1[k] == number) return k
        }
        return -1
    }
}