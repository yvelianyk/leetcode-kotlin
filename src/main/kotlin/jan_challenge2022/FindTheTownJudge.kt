package jan_challenge2022

fun main() {
    val res = FindTheTownJudge().findJudge(2, arrayOf(
        intArrayOf(1,2),
    ))
    println(res)
}

class FindTheTownJudge {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        if (n == 1 && trust.isEmpty()) return 1
        val count = mutableMapOf<Int, Int>()
        for (ints in trust) {
            count[ints[1]] = (count[ints[1]] ?: 0) + 1
        }
        var result = -1
        for (entry in count) {
            if (entry.value == n - 1) result = entry.key
        }
        if (result == -1) return -1
        for (ints in trust) if (ints[0] == result) return -1

        return result
    }
    
}