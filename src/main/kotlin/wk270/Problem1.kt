package wk270

fun main() {
    val res = Problem1().findEvenNumbers(intArrayOf(2, 1, 3, 0))
    println(res)
}

class Problem1 {
    private lateinit var digits: IntArray
    private var result = mutableSetOf<Int>()

    fun findEvenNumbers(digits: IntArray): IntArray {
        this.digits = digits
        backtrack(0, 0, 100)

        return result.toIntArray().sortedArray()
    }

    private fun backtrack(index: Int, currNum: Int, currMultiplier: Int) {
        if (index == 3) {
            if (currNum % 2 == 0) result.add(currNum)
            return
        }

        for ((currIndex, digit) in digits.withIndex()) {
            if ((index == 0 && digit == 0) || digit == -1) continue
            val temp = digits[currIndex]
            digits[currIndex] = -1
            backtrack(index + 1, currNum + digit * currMultiplier, currMultiplier / 10)
            digits[currIndex] = temp
        }
    }
}