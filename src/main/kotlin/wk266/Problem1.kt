package wk266

fun main() {
    val res = Problem1().countVowelSubstrings("cuaieuouac")
    println(res)
}

class Problem1 {
    fun countVowelSubstrings(word: String): Int {
        var count = 0
        for (i in 0 until word.length) {
            for (j in i until word.length) {
                if (isVowel(word.substring(i..j))) {
                    count++
                }
            }
        }
        return count
    }

    private fun isVowel(str: String): Boolean {
        val set = mutableSetOf<Char>('a', 'e', 'i', 'o', 'u')
        val charArray = str.toCharArray()
        for (c in charArray) {
            if (!set.contains(c)) return false
        }
        for (c: Char in set) {
            if (!str.contains(c)) return false
        }

        return true
    }
}
