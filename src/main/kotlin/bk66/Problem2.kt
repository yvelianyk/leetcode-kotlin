package bk66

fun main() {
    val result = Problem2().minimumBuckets("H.H.H")
    println(result)
}

class Problem2 {
    fun minimumBuckets(street: String): Int {
        val street2 = "H" + street + "H"
        val chars = street2.toCharArray()

        var result = 0
        for (index in 1 until chars.size - 1) {
            if (chars[index] == 'H') {
                val prevIndex = index - 1
                val nextIndex = index + 1
                if (chars[prevIndex] == 'H' && chars[nextIndex] == 'H') return -1
                if (chars[nextIndex] == '.' && chars[prevIndex] != 'B') {
                    chars[nextIndex] = 'B'
                    result++
                    continue
                }

                if (chars[nextIndex] == 'H' && chars[prevIndex] == '.') {
                    chars[prevIndex] = 'B'
                    result++
                }
            }
        }
        return result
    }
}
