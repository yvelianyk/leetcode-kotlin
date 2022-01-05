package jan_challenge2022

fun main() {
    val res = IntervalsSum().getDistances(
        intArrayOf(2, 1, 3, 1, 2, 3, 3)
    )
    println(res)
}

class IntervalsSum {
    fun getDistances(arr: IntArray): LongArray {
        val map = mutableMapOf<Int, MutableList<Int>>()
        for ((i, value) in arr.withIndex()) {
            val curr = map[value] ?: mutableListOf()
            curr.add(i)
            map[value] = curr
        }
        val result = LongArray(arr.size)
        for (entry in map) {
            val list: MutableList<Int> = entry.value
            val pref = MutableList<Long>(list.size + 1) { 0 }
            for (i in list.indices) {
                pref[i + 1] = pref[i] + list[i]
            }
            for (i in list.size - 1 downTo 0) {
                val number = list[i].toLong()
                val prevSum = (number * (i + 1) - pref[i + 1])
                val nextSum = ((pref[list.size] - pref[i]) - number * (list.size - i))
                result[list[i]] = prevSum + nextSum
            }
        }
        return result
    }
}
