package dec_challenge2021

fun main() {
    val res = ConsecutiveChars().maxPower("triplepillooooow")
    println(res)
}

class ConsecutiveChars {
    fun maxPower(s: String): Int {
        val chars = s.toCharArray()
        var res = 0
        var curr = 0
        var i = 0
        var j = 0
        while (j < chars.size) {
            if (chars[i] == chars[j]) {
                res = maxOf(res, ++curr)
                j++
            } else {
                curr = 0
                i = j
            }
        }
        return res
    }
}