package aug_challenge2023

fun main() {
    val res = RepeatedSubstring().repeatedSubstringPattern("a")
    print(res)
}

class RepeatedSubstring {
    fun repeatedSubstringPattern(s: String): Boolean {
        for (i in 1..s.length / 2) {
            if (isValid(s, i)) return true
        }

        return false
    }

    private fun isValid(s: String, size: Int): Boolean {
        val equal = s.substring(0, size)
        var l = 0
        while (l < s.length) {
            if (l + size > s.length) return false
            val sub = s.substring(l, l+size)
            if (equal != sub) return false
            l += size
        }

        return true
    }
}