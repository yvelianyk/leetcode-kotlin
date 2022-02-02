package wk278

fun main() {
    val res = Problem1().findFinalValue(
        intArrayOf(
            5, 3, 6, 1, 12
        ),
        3
    )
    println(res)
}

class Problem1 {
    fun findFinalValue(nums: IntArray, original: Int): Int {
        val set = nums.toSet()
        var originalRep = original
        while (set.contains(originalRep)) {
            originalRep *= 2
        }
        return originalRep
    }
}
