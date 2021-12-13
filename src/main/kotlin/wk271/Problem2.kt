package wk271

fun main() {
    val res = Problem2().subArrayRanges(intArrayOf(1,2,3))
    println(res)
}

class Problem2 {
    private var result: Long = 0
    fun subArrayRanges(nums: IntArray): Long {
        printSubArrays(nums, 0, 0 )
        return result
    }

    private fun printSubArrays(arr: IntArray, start: Int, end: Int) {
        if (end == arr.size) {
            return
        } else if (start > end) {
            printSubArrays(arr, 0, end + 1)
        } else {
            var min = Int.MAX_VALUE
            var max = Int.MIN_VALUE
            for (i in start .. end) {
                if (arr[i] >= max) {
                    max = arr[i]
                }
                if (arr[i] <= min) {
                    min = arr[i]
                }
            }
            result += max - min
            printSubArrays(arr, start + 1, end)
        }
        return
    }
}