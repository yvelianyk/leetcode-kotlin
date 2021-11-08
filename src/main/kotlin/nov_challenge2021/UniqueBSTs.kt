package nov_challenge2021

fun main() {
    val result = UniqueBSTs().numTrees(5)
    assert(result == 42)
    println(result)
}

class UniqueBSTs {
    private lateinit var memo: IntArray
    fun numTrees(n: Int): Int {
        memo = IntArray(n + 1) { -1 }
        return count(n)
    }

    private fun count(n: Int): Int {
        if (memo[n] != -1) return memo[n]
        if (n == 0 || n == 1) return 1
        var result = 0
        for (i in 1..n) result += count(n - i) * count(i - 1)
        memo[n] = result
        return result
    }
}
