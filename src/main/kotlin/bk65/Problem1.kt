package bk65

import kotlin.math.abs

fun main() {
    // "aaaa"
    // "bccb"
    val resul = Problem1().checkAlmostEquivalent("aaaa", "bccb")
    println(resul)
}
class Problem1 {
    fun checkAlmostEquivalent(word1: String, word2: String): Boolean {
        val map1 = word1.toCharArray().toList().groupingBy { it }.eachCount()
        val map2 = word2.toCharArray().toList().groupingBy { it }.eachCount()
        val bigger = if (map1.size > map2.size) map1 else map2
        val smaller = if (map1.size <= map2.size) map1 else map2
        for (entry: Map.Entry<Char, Int> in bigger) {
            val char1 = entry.key
            val char1Count = entry.value
            val char2Count = smaller[char1] ?: 0
            if (abs(char1Count - char2Count) > 3) return false
        }
        for (entry: Map.Entry<Char, Int> in smaller) {
            val char1 = entry.key
            val char1Count = entry.value
            val char2Count = bigger[char1] ?: 0
            if (abs(char1Count - char2Count) > 3) return false
        }
        return true
    }
}
