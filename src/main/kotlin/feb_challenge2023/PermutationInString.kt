package feb_challenge2023

fun main() {
    val res = PermutationInString().checkInclusion("ab", "eidbaoox")
    println(res)
}

class PermutationInString {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false
        val map1 = s1.toList().groupingBy { it }.eachCount().toMutableMap()
        val map2: MutableMap<Char, Int> = mutableMapOf<Char, Int>()
        for (i in s1.indices) {
            map2[s2[i]] = map2.getOrDefault(s2[i], 0) + 1
        }

        for (i in 0 until s2.length - s1.length) {
            if (compare(map2, map2)) return true
            val prev = s2[i]
            val next = s2[i + s1.length]
            val prevVal = map2.getOrDefault(prev, 0)
            map2[prev] = prevVal - 1
            if (prevVal - 1 <= 0) map2.remove(prev)
            val nextVal = map2.getOrDefault(next, 0)
            map2[next] = nextVal + 1
        }
        return compare(map1, map2)
    }

    private fun compare(map1: MutableMap<Char, Int>, map2: MutableMap<Char, Int>): Boolean {
        if (map1.size != map2.size) return false
        for (mutableEntry in map1) {
            if (!map2.containsKey(mutableEntry.key)) return false
            if (map2[mutableEntry.key] != mutableEntry.value) return false
        }
        return true
    }
}