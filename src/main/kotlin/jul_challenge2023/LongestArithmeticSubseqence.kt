package jul_challenge2023

fun main() {
//    val res = LongestArithmeticSubseqence().longestSubsequence(
//        intArrayOf(1, 5, 7, 8, 5, 3, 4, 2, 1),
//        -2
//    )
    val res = LongestArithmeticSubseqence().longestSubsequence(
        intArrayOf(1,3,5,7),
        1
    )
    println(res)
}

class LongestArithmeticSubseqence {
    fun longestSubsequence(arr: IntArray, difference: Int): Int {
        val map = mutableMapOf<Int, Int>()
        var result = 1
        for (item in arr) {
            val before = map.getOrDefault(item - difference, 0)
            map[item] = before + 1
            result = maxOf(result, before + 1)
        }
        return result
    }

}