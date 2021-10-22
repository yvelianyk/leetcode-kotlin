package oct_challenge2021

fun main() {
    val result = SortCharsByFrequency().frequencySort("bAabb")
    println(result)
}

class SortCharsByFrequency {
    fun frequencySort(s: String): String {
        return s
            .groupBy { it }
            .map { (_, chars) -> chars.joinToString(separator = "") }
            .sortedByDescending { chars -> chars.length }
            .joinToString(separator = "")
    }
}
