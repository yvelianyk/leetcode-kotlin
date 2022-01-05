package jan_challenge2022

fun main() {
    val res = PalindromePartitioning().partition("aab")
    println(res)
}

class PalindromePartitioning {
    private val result = mutableListOf<MutableList<String>>()

    fun partition(s: String): List<List<String>> {
        backtrack(0, s, mutableListOf())
        return mutableListOf()
    }

    private fun backtrack(index: Int, s: String, curr: MutableList<String>) {
        if (index == s.length) {
            result.add(curr.toList() as MutableList<String>)
            return
        }

        for (i in index until s.length) {
            val sub = s.substring(index, i + 1)
            if (isPalindrome(sub)) {
                curr.add(sub)
                backtrack(i + 1, s, curr)
                curr.removeAt(curr.size - 1)
            }
        }
    }

    private fun isPalindrome(str: String): Boolean {
        val chars = str.toCharArray()
        var left = 0
        var rigth = chars.size - 1
        while (left < rigth) {
            if (chars[left++] != chars[rigth--]) return false
        }
        return true
    }
}
