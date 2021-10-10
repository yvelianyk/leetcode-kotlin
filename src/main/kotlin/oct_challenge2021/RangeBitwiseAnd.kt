package oct_challenge2021

import kotlin.math.log2

fun main() {
    val res = RangeBitwiseAnd().rangeBitwiseAnd(5, 7)
    println(res)
}

class RangeBitwiseAnd {
    fun rangeBitwiseAnd(left: Int, right: Int): Int {
        if (
            left == 0 ||
            right == 0 ||
            // if the number of bits are different between left and right
            // then result will be always zero. Example: 7 = 111, 8 = 1000.
            // Bitwise AND will be 7 = 0111, 8 = 1000 => 0 & 1 = 0, 1 & 0 = 0, 1 & 0 = 0, 1 & 0 = 0.
            // Hence result is zero
            log2(left.toDouble()).toInt() != log2(right.toDouble()).toInt()
        ) return 0
        var result = left
        for (i in left..right) result = result and i
        return result
    }
}