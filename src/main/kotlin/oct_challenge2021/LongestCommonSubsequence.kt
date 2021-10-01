package oct_challenge2021

fun main() {
    assert(longestCommonSubsequence("abcde", "ace") == 3)
    assert(longestCommonSubsequence("abc", "def") == 0)
    assert(longestCommonSubsequence("abc", "abc") == 2)
    val res = longestCommonSubsequence("abc", "abc")
    println(res)
}

fun longestCommonSubsequence(text1: String, text2: String): Int {
    val memo: Array<Array<Int>> = Array(text1.length) {Array(text2.length) {-1} }
    return getMax(text1, text2, 0, 0, memo)
}

private fun getMax(text1: String, text2: String, index1: Int, index2: Int, memo: Array<Array<Int>>): Int {
    if (index1 == text1.length || index2 == text2.length) return 0
    if (memo[index1][index2] != -1) return memo[index1][index2]

    val char1: Char = text1[index1]
    val char2: Char = text2[index2]

    val result = when (char1) {
        char2 -> {
            getMax(text1, text2, index1 + 1, index2 + 1, memo) + 1
        }
        else -> {
            val res1 = getMax(text1, text2, index1, index2 + 1, memo)
            val res2 = getMax(text1, text2, index1 + 1, index2, memo)
            maxOf(res1, res2)
        }
    }
    memo[index1][index2] = result
    return result
}