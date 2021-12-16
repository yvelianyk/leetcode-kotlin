package dec_challenge2021

fun main() {
    val res = SubarraySumsDivisibleByK().subarraysDivByK(intArrayOf(4,5,0,-2,-3,1), 5)
    println(res)
}

class SubarraySumsDivisibleByK {
    fun subarraysDivByK(nums: IntArray, k: Int): Int {
        val count = mutableMapOf<Int,Int>()
        var sum = 0
        var result = 0
        count[0] = 1
        for (num in nums) {
            sum += num
            val div = count[sum % k] ?: 0
            count[sum % k] = (count[sum % k] ?: 0) + 1
            result += div
        }
        return result
    }
}