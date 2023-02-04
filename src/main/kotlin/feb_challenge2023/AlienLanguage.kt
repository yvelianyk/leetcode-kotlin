package feb_challenge2023

fun main() {
    val res = AlienLanguage().isAlienSorted(
        arrayOf("l","h"),
        "xkbwnqozvterhpjifgualycmds"
    )
    println(res)
}

class AlienLanguage {
    fun isAlienSorted(words: Array<String>, order: String): Boolean {
        val sorted = words.toList().sortedWith(object : Comparator <String> {
            override fun compare (p0: String, p1: String) : Int {
                val bigger = if (p0.length >= p1.length) p0 else p1
                val smaller = if (p0.length < p1.length) p0 else p1
                val firstIsBigger = p0.length >= p1.length
                for (i in smaller.indices) {
                    val smallerIndex = order.indexOf(smaller[i])
                    val biggerIndex = order.indexOf(bigger[i])
                    if (smallerIndex > biggerIndex) return if (firstIsBigger) -1 else 1
                    if (smallerIndex < biggerIndex) return if (firstIsBigger) 1 else -1
                }
                if (p0.length != p1.length) return if (firstIsBigger) 1 else -1
                return 0
            }
        })
        val original = words.toList()
        for (i in sorted.indices) {
            if (sorted[i] != original[i]) return false
        }
        return true
    }
}