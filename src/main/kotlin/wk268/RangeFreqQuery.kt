package wk268

fun main() {
    val query = RangeFreqQuery(intArrayOf(12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56))
    val res1 = query.query(1, 2, 4)
    println(res1)
}

class RangeFreqQuery(arr: IntArray) {
    private val map = mutableMapOf<Int, MutableList<Int>>()

    init {
        for (i in arr.indices) {
            val currArr = map.getOrDefault(arr[i], mutableListOf())
            currArr.add(i)
            map[arr[i]] = currArr
        }
    }

    fun query(left: Int, right: Int, value: Int): Int {
        val curr: MutableList<Int> = map[value] ?: return 0
        var lower = curr.binarySearch(left)
        var upper = curr.binarySearch(right)
        if (lower < 0) {
            lower = -(lower + 1)
        }
        if (upper < 0) {
            upper = -(upper + 2)
        }

        return upper - lower + 1
    }
}
