package wk274

fun main() {
    val res = Problem2().numberOfBeams(
        arrayOf(
            "000",
            "111",
            "000",
        )
    )
    println(res)
}

class Problem2 {
    fun numberOfBeams(bank: Array<String>): Int {
        var result = 0
        var prev = 0
        for (s in bank) {
            val count = numOfBeams(s)
            if (count > 0) {
                result += count * prev
                prev = count
            }
        }
        return result
    }

    private fun numOfBeams(s: String): Int {
        return s.filter { it == '1' }.count()
    }
}
