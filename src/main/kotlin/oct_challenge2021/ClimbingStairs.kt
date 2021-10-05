package oct_challenge2021

fun main() {
    val result = SolutionClimbingStairs().climbStairs(3)
    assert(result == 3)
    println(result)
}

class SolutionClimbingStairs {
    lateinit var memo: IntArray
    fun climbStairs(n: Int): Int {
        memo = IntArray(n + 1) { -1 }
        return getWays(1, n)
    }

    fun getWays(position: Int, n: Int): Int {
        if (position >= n) return 1
        if (memo[position] != -1) return memo[position]
        val way1 = getWays(position + 1, n)
        val way2 = getWays(position + 2, n)
        memo[position] = way1 + way2
        return way1 + way2
    }
}