package bk61

fun main() {
//    val arr = intArrayOf(1, 3, 4, 2, 6, 8) // 1,3,4
    val arr = intArrayOf(0, 0, 0, 0) // 0,0
    val res = FindOrigArrayFromDoubleArr().findOriginalArray(arr)
    println(res)
}

class FindOrigArrayFromDoubleArr {
    fun findOriginalArray(changed: IntArray): IntArray {
        if (changed.size % 2 != 0) return intArrayOf()
        val count: MutableMap<Int, Int> = changed.toList().groupingBy { it }.eachCount() as MutableMap<Int, Int>
        changed.sort()
        val result = mutableListOf<Int>()
        for (i in changed) {
            if (count.containsKey(i) && count[i]!! > 0 && count.containsKey(i * 2) && count[i * 2]!! > 0) {
                if (i == 0 && count[i] == 1) continue
                result.add(i)
                count[i * 2] = (count[i * 2] ?: 0) - 1
                count[i] = (count[i] ?: 0) - 1
            }
        }

        if (result.size == changed.size / 2) return result.toIntArray()
        return intArrayOf()
    }
}
