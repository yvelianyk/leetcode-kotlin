package dec_challenge2021

import kotlin.math.log2

fun main() {
    val res = ComplementNumber().findComplement(1)
    println(res)
}

class ComplementNumber {
    fun findComplement(num: Int): Int {
        val numOfBits = (log2(num.toDouble()) + 1).toInt()
        val shifted = 1 shl numOfBits
        val ones = shifted - 1
        return num xor ones
    }
}