package nov_challenge2021

fun main() {
    val max = BuyAndSellStockII().maxProfit(intArrayOf(7, 1, 5, 3, 6, 4))
    println(max)
}

class BuyAndSellStockII {
    private lateinit var prices: IntArray
    private lateinit var memo: Array<IntArray>
    fun maxProfit(prices: IntArray): Int {
        this.prices = prices
        memo = Array(prices.size) {
            IntArray(2) {
                -1
            }
        }
        return getMax(0, 0)
    }

    // 0 - buy operation(op)
    // 1 - sell operation(op)
    private fun getMax(day: Int, op: Int): Int {
        if (day == prices.size) return 0
        if (memo[day][op] != -1) return memo[day][op]
        memo[day][op] = when (op) {
            0 -> {
                maxOf(
                    getMax(day + 1, op), // skip
                    getMax(day + 1, 1) - prices[day] // buy
                )
            }
            else -> {
                maxOf(
                    getMax(day + 1, op), // skip
                    prices[day] + getMax(day + 1, 0) // sell
                )
            }
        }
        return memo[day][op]
    }
}
