package oct_challenge2021

fun main() {
    val res = PerferctSquares().numSquares(12)
    println(res)
}

class PerferctSquares {
    private val mapSquares = mutableMapOf<Int, List<Int>>()
    private lateinit var memo: IntArray

    fun numSquares(n: Int): Int {
        memo = IntArray(n + 1) { -1 }
        return getMin(n)
    }

    fun getMin(n: Int): Int {
        if (n == 0) return 0
        if (n == 1) return 1
        if (memo[n] != -1) return memo[n]

        val squares = initList(n)
        var min = Int.MAX_VALUE
        for (square in squares) {
            min = minOf(min, getMin(n - square))
        }
        memo[n] = min + 1
        return memo[n]
    }

    private fun initList(n: Int): List<Int> {
        if (mapSquares.containsKey(n)) {
            return mapSquares[n]!!
        }
        val listSquares = mutableListOf<Int>()
        for (i in 1..n) {
            if (i * i <= n) {
                listSquares.add(i * i)
            }
        }
        mapSquares[n] = listSquares.asReversed()
        return mapSquares[n]!!
    }
}
