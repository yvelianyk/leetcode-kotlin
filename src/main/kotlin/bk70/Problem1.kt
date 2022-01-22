package bk70

fun main() {
    val res = Problem1().minimumCost(intArrayOf(5,5))
    println(res)
}

class Problem1 {
    fun minimumCost(cost: IntArray): Int {
        cost.sortDescending()
        var res = 0
        var count = 0
        for (i in cost) {
            if (count < 2) {
                count++
                res += i
            }
            if (count == 2) {
                count++
                continue
            }
            if (count > 2) {
                count = 0
            }
        }
        return res
    }
}
