package feb_challenge2023

fun main() {
//    val res = BestTimeToBuySellStocks().maxProfit(intArrayOf(7, 1, 5, 3, 6, 4))
    val res = BestTimeToBuySellStocks().maxProfit(intArrayOf(7, 6, 4,3,1))
    println(res)
}

class BestTimeToBuySellStocks {
    fun maxProfit(prices: IntArray): Int {
        var min = prices[0]
        var max = min
        var profit = 0
        for (price in prices) {
            when {
                price < min -> {
                    min = price
                    max = price
                }
                price > max -> max = price
            }
            profit = maxOf(profit, max - min)
        }
        return profit
    }
}