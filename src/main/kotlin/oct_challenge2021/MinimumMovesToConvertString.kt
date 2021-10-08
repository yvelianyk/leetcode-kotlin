package oct_challenge2021

fun main() {
    val res1 = MinimumMovesToConvertString().minimumMoves("0000")
    assert(res1 == 0)
    val res2 = MinimumMovesToConvertString().minimumMoves("XXOX")
    assert(res2 == 2)
    val res3 = MinimumMovesToConvertString().minimumMoves("XXX")
    assert(res3 == 1)
}

class MinimumMovesToConvertString {
    fun minimumMoves(s: String): Int {
        var index = 0
        var count = 0
        while (index < s.length) {
            val char = s[index]
            if (char == 'X') {
                index += 3
                count++
            } else {
                index++
            }
        }
        return count
    }
}