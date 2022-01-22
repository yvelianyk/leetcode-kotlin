package bk70

fun main() {
    val res = Problem2().numberOfArrays(
        intArrayOf(0),
        0,
        0
    )
}

class Problem2 {
    fun numberOfArrays(differences: IntArray, lower: Int, upper: Int): Int {
        val arr = LongArray(differences.size + 1)
        arr[0] = lower.toLong()
        var min = lower.toLong()
        var max = lower.toLong()
        for (i in 1 until arr.size) {
            val elem = differences[i - 1] + arr[i - 1]
            min = minOf(elem, min)
            max = maxOf(elem, max)
            arr[i] = elem
        }
        val diff = (max - min)
        var start = lower.toLong()
        var result = 0L
        while (start + diff <= upper.toLong()) {
            start++
            result++
        }

        return result.toInt()
    }
}
