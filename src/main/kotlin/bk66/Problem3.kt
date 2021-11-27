package bk66

fun main() {
    val result = Problem3().minCost(intArrayOf(0, 3), intArrayOf(2, 3), intArrayOf(5, 4, 3), intArrayOf(8, 2, 6, 7))
    println(result)
}

class Problem3 {
    fun minCost(startPos: IntArray, homePos: IntArray, rowCosts: IntArray, colCosts: IntArray): Int {
        val startI = startPos[0]
        val startJ = startPos[1]
        val homeI = homePos[0]
        val homeJ = homePos[1]
        if (startI == homeI && startJ == homeJ) return 0
        var result = 0

        if (startJ < homeJ) {
            for (i in startJ + 1..homeJ) result += colCosts[i]
        } else {
            for (i in startJ - 1 downTo homeJ) result += colCosts[i]
        }

        if (startI < homeI) {
            for (i in startI + 1..homeI) result += rowCosts[i]
        } else {
            for (i in startI - 1 downTo homeI) result += rowCosts[i]
        }
        return result
    }
}
