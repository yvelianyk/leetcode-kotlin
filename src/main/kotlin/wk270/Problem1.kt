package wk270

fun main() {
    val res = Problem1().findEvenNumbers(intArrayOf(2, 1, 3, 0))
    println(res)
}


class Problem1 {
    fun findEvenNumbers(digits: IntArray): IntArray {
        val result = mutableSetOf<Int>()
        backtrack(0, result, digits, 0, 100)

        return result.toIntArray().sortedArray()
    }

    private fun backtrack(index: Int, result: MutableSet<Int>, digits: IntArray, currNum: Int, currMult: Int) {
        if (index == 3) {
            if (currNum % 2 == 0) result.add(currNum)
            return
        }

        for ((ind, i) in digits.withIndex()) {
            if ((index == 0 && i == 0) || i == -1) continue
            val temp = digits[ind]
            digits[ind] = -1
            backtrack(index + 1, result, digits, currNum + i * currMult, currMult / 10)
            digits[ind] = temp
        }

    }
}