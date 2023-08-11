package aug_challenge2023

fun main() {
//    val res = CoinChangeII().change(5, intArrayOf(1, 2, 5))
//    val res = CoinChangeII().change(10, intArrayOf(10))
    val res = CoinChangeII().change(13, intArrayOf(1,2,5,6,7))
    println(res)
}

class CoinChangeII {
    private lateinit var coins: IntArray
    private lateinit var memo: Array<IntArray>

    fun change(amount: Int, coins: IntArray): Int {
        this.coins = coins
        memo = Array(amount + 1) { IntArray(coins.size) { -1 } }
        return calculate(amount, 0)
    }

    private fun calculate(amount: Int, index: Int): Int {
        if (amount == 0) return 1
        if (amount < 0) return 0
        if (index > coins.lastIndex) return 0
        if (memo[amount][index] != -1) return memo[amount][index]

        val pick = calculate(amount - coins[index], index)
        val notPick = calculate(amount, index + 1)
        memo[amount][index] = pick + notPick
        return pick + notPick
    }
}