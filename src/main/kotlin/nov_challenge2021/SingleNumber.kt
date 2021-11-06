package nov_challenge2021

fun main() {
    val array = intArrayOf(1, 2, 3, 3, 2, 5)
    val res = SingleNumber().singleNumber(array)
    println(res)
}

class SingleNumber {
    fun singleNumber(nums: IntArray): IntArray {
        val diffBitNum = nums.reduce { acc, i -> acc xor i }
        val diffBit = diffBitNum and -diffBitNum
        val first = nums.filter { it and diffBit == 0 }.reduce { acc, i -> acc xor i }
        return intArrayOf(first, first xor diffBitNum)
    }
}
