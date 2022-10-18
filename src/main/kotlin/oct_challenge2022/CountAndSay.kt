package oct_challenge2022

fun main() {
    val res = CountAndSay().countAndSay(30)
    println(res)
}

class CountAndSay {
    fun countAndSay(n: Int): String {
        var prev = ""
        for (i in 1..n) {
            prev = (if (i == 1) "1" else say(prev))
        }
        return prev
    }

    private fun say(str: String): String {
        var res = ""
        var prev = 'a'
        var count = 0
        for (char in str) {
            if (prev == 'a') prev = char
            if (char == prev) {
                count++
            } else {
                res += count.toString()
                res += prev
                count = 1
                prev = char
            }
        }
        if (count > 0) {
            res += count.toString()
            res += prev
        }

        return res
    }
}