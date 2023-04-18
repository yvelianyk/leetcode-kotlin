package apr_challenge2023

fun main() {
    val res = MergeStringsAlternatively().mergeAlternately("", "pqr")
    println(res)
}


class MergeStringsAlternatively {
    fun mergeAlternately(word1: String, word2: String): String {
        var i = 0
        var j = 0
        var step = 0
        val result = StringBuilder()
        while (i < word1.length || j < word2.length) {
            when (step) {
                0 -> {
                    if (i < word1.length) result.append(word1[i])
                    step = 1
                    i++
                }
                else -> {
                    if (j < word2.length) result.append(word2[j])
                    step = 0
                    j++
                }
            }
        }
        return result.toString()
    }
}