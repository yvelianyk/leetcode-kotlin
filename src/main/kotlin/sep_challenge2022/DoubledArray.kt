package sep_challenge2022

fun main() {
//    val result = DoubledArray().findOriginalArray(intArrayOf(1,3,4,2,6,8))
//    val result = DoubledArray().findOriginalArray(intArrayOf(0))
//    val result = DoubledArray().findOriginalArray(intArrayOf(0,1,2,0,2,4))
    val result = DoubledArray().findOriginalArray(intArrayOf(1,4,5,2,8,10,4,16,20))
    println(result)
}

class DoubledArray {
    fun findOriginalArray(changed: IntArray): IntArray {
        if (changed.size % 2 != 0) return intArrayOf()
        val count: MutableMap<Int, Int> = changed.toList().groupingBy { it }.eachCount() as MutableMap<Int, Int>
        changed.sort()
        val result = mutableListOf<Int>()
        for (i in changed) {
            if (count.containsKey(i) && count[i]!! > 0 && count.containsKey(i * 2) && count[i * 2]!! > 0) {
                if (i == 0 && count[i] == 1) continue
                result.add(i)
                val value = count[i * 2] ?: 0
                count[i * 2] = value - 1
                val valueI = count[i] ?: 0
                count[i] = valueI - 1
            }
        }

        if (result.size == changed.size / 2) return result.toIntArray()
        return intArrayOf()
    }
}