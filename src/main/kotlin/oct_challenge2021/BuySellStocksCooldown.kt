package oct_challenge2021

fun main() {
    val res = BuySellStocksCooldown().maxProfit(intArrayOf(1, 2, 3, 0, 2))
    assert(res == 3)
    println(res)
}

class BuySellStocksCooldown {
    private lateinit var prices: IntArray
    private lateinit var memo: Array<Array<Int>>

    fun maxProfit(prices: IntArray): Int {
        memo = Array(prices.size) {
            Array(2) {
                -1
            }
        }
        this.prices = prices
        return getMax(0, 0)
    }

    // 0 - buy, 1 - sell
    private fun getMax(day: Int, operation: Int): Int {
        if (day >= prices.size) return 0
        if (memo[day][operation] != -1) return memo[day][operation]
        memo[day][operation] = when (operation) {
            0 -> {
                val buy = -prices[day] + getMax(day + 1, 1)
                val skip = getMax(day + 1, 0)
                maxOf(buy, skip)
            }
            else -> {
                val sell = prices[day] + getMax(day + 2, 0)
                val skip = getMax(day + 1, 1)
                maxOf(sell, skip)
            }
        }
        return memo[day][operation]
    }
}
