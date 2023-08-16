package aug_challenge2023

fun main() {
//    val res = MaxPairSumInArray().maxSum(intArrayOf(51,71,17,24,42))
    val res = MaxPairSumInArray().maxSum(intArrayOf(10,68,5,62,5,100,44,36))
    println(res)
}

class MaxPairSumInArray {
    fun maxSum(nums: IntArray): Int {
        var max = -1
        for (i in 0 until nums.lastIndex) {
            val dig1 = toDigits(nums[i]).maxOrNull() ?: 0
            for (j in i + 1..nums.lastIndex) {
                val dig2 = toDigits(nums[j]).maxOrNull() ?: 0
                if (dig1 == dig2 && dig1 != 0) {
                    max = maxOf(max, nums[i] + nums[j])
                }
            }
        }
        return max
    }

    private fun toDigits(number: Int): IntArray {
        val res = mutableListOf<Int>()
        var resNum = number
        do  {
            res.add(resNum % 10)
            resNum /= 10
        } while (resNum > 0)
        return res.toIntArray()
    }
}