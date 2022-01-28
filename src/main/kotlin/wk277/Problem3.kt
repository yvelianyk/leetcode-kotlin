package wk277

class Problem3 {
    fun findLonely(nums: IntArray): List<Int> {
        val mapCount = nums.toList().groupingBy { it }.eachCount()
        val result = mutableListOf<Int>()
        for (entry in mapCount) {
            val count = entry.value
            val num = entry.key
            if (count == 1 && !mapCount.containsKey(num - 1) && !mapCount.containsKey(num + 1)) {
                result.add(num)
            }
        }
        return result
    }
}
