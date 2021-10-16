package oct_challenge2021

fun main() {
//    val prices = intArrayOf(3, 3, 5, 0, 0, 3, 1, 4)
    val prices = intArrayOf(1, 2, 3, 4, 5)
    val result = BuyAndSellStocksIII().maxProfit(prices)
    println(result)
}

class BuyAndSellStocksIII {
    private lateinit var prices: IntArray
    private lateinit var memo: Array<Array<Array<Int>>>
    fun maxProfit(prices: IntArray): Int {
        this.prices = prices
        this.memo = Array(prices.size) {
            Array(2) {
                Array(3) {
                    -1
                }
            }
        }

        return getMax(0, 0, 0)
    }

    // operation: 0 - buy, 1 - sell
    private fun getMax(day: Int, operation: Int, transCount: Int): Int {
        if (day >= prices.size) return 0
        if (transCount == 2) {
            return 0
        }
        if (memo[day][operation][transCount] != -1) {
            return memo[day][operation][transCount]
        }
        memo[day][operation][transCount] = when (operation) {
            0 -> {
                val buy = -prices[day] + getMax(day + 1, 1, transCount)
                val skip = getMax(day + 1, operation, transCount)
                maxOf(buy, skip)
            }
            else -> {
                val sell = +prices[day] + getMax(day + 1, 0, transCount + 1)
                val skip = getMax(day + 1, operation, transCount)
                maxOf(sell, skip)
            }
        }
        return memo[day][operation][transCount]
    }
}
