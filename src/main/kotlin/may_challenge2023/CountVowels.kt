package may_challenge2023

fun main() {
    val res = CountVowels().maxVowels("leetcooe", 3)
    println(res)
}

class CountVowels {
    private val vowels = setOf('a','e','i','o','u')
    fun maxVowels(s: String, k: Int): Int {
        var res = 0
        for (i in 0 until k) if (vowels.contains(s[i])) res++
        var max = res
        var left = 0
        var right = k
        while (right < s.length) {
            if (vowels.contains(s[right++])) res++
            if (vowels.contains(s[left++])) res--
            max = maxOf(res, max)
        }
        return max
    }
}