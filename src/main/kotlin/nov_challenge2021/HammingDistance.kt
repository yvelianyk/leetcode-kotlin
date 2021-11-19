package nov_challenge2021

fun main() {
    val res = HammingDistance().hammingDistance(1, 4)
    println(res)
}

class HammingDistance {
//    fun hammingDistance(x: Int, y: Int): Int {
//        val xored = x xor y
//        val numOfBits = (log2(xored.toDouble()) + 1).toInt()
//        var count = 0
//        var first = 1
//        for (i in 1..numOfBits) {
//            if (xored and first != 0) count++
//            first = first shl 1
//        }
//        return count
//    }

    // Count 1 bits by and with 1 and shifting number to right
    // It'll compare last bit with 1 and result always be either 0 or 1
    fun hammingDistance(x: Int, y: Int): Int {
        var xored = x xor y
        var count = 0
        while (xored > 0) {
            count += xored and 1
            xored = xored shr 1
        }

        return count
    }

    // Not working with Kotlin version on leetcode
//    fun hammingDistance(x: Int, y: Int): Int {
//        return (x xor y).countOneBits()
//    }
}
