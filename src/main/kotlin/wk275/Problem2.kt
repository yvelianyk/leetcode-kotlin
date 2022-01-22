package wk275

fun main() {
    val res = Problem2().minSwaps(intArrayOf(0,0,0))
    println(res)
}

class Problem2 {
    fun minSwaps(nums: IntArray): Int {
        val numOfOnes = nums.filter { it == 1 }.size
        if (numOfOnes == 0) return 0
        val numsList = nums.toMutableList()
        numsList.addAll(nums.toMutableList())
        var currOnes = 0
        var currZeros = 0
        for (i in 0 until numOfOnes) {
            if (numsList[i] == 1) currOnes++ else currZeros++
        }
        var res = currZeros
        var start = 0
        var end = numOfOnes - 1
        var prevFirst = numsList[start]
        var newNext: Int
        while (end < numsList.size - 1) {
            if (prevFirst == 0) currZeros--
            prevFirst = numsList[++start]
            newNext = numsList[++end]
            if (newNext == 0) currZeros++
            res = minOf(res, currZeros)
        }
        return res
    }
}
