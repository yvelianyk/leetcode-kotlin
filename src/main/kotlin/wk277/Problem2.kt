package wk277

fun main() {
//    val res = Problem2().rearrangeArray(
//        intArrayOf(
//            28,
//            -41,
//            22,
//            -8,
//            -37,
//            46,
//            35,
//            -9,
//            18,
//            -6,
//            19,
//            -26,
//            -37,
//            -10,
//            -9,
//            15,
//            14,
//            31
//        )
//    )
    val res = Problem2().rearrangeArray(intArrayOf(-1, 1))
    println(res)
}

class Problem2 {
    fun rearrangeArray(nums: IntArray): IntArray {
        val pos = mutableListOf<Int>()
        val neg = mutableListOf<Int>()
        val res = mutableListOf<Int>()
        for (num in nums) {
            if (num > 0) {
                pos.add(num)
            } else {
                neg.add(num)
            }
        }

        var isPos = true
        var start = 0
        while (start < pos.size) {
            val num = if (isPos) pos[start] else neg[start]
            res.add(num)
            if (isPos) {
                isPos = false
            } else {
                start++
                isPos = true
            }
        }

        return res.toIntArray()
    }
}
