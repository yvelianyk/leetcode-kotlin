package mar_challenge2023

fun main() {
    val res = StringCompression().compress(charArrayOf('a', 'a', 'b', 'b', 'c', 'd', 'd', 'd', 'd','d', 'd','d', 'd','d', 'd','d', 'd','d', 'd','d', 'd' ))
    println(res)
}

class StringCompression {
    fun compress(chars: CharArray): Int {
        var prev = chars[0]
        var res = "" + prev
        var counter = 1
        for (i in 1 until chars.size) {
            val curr = chars[i]
            if (curr == prev) {
                counter++
            } else {
                res += if (counter > 1) {
                    ("" + counter) + curr
                } else {
                    "" + curr
                }
                prev = curr
                counter = 1
            }
        }
        if (counter > 1) res += "" + counter
        for (i in res.indices) chars[i] = res[i]
        return res.length
    }
}