package sep_challenge2021

fun main() {
    var array = intArrayOf(1,1,0,1,1,1)
    var result = findMaxConsecutiveOnes(array)
    println(result)
}

fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var start = 0
    var end = 0
    var result = 0
    while (end < nums.size) {
        when (nums[end]) {
            1 -> result = maxOf(result, end++ - start + 1)
            0 -> start = ++end
        }
    }
    return result
}