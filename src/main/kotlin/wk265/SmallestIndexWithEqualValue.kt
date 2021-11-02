package wk265

class SmallestIndexWithEqualValue {
    fun smallestEqual(nums: IntArray): Int {
        return nums
            .mapIndexed { index, i -> Pair(index, i) }
            .filter { it.first % 10 == it.second }
            .map { it.first }
            .firstOrNull() ?: -1
    }
}
