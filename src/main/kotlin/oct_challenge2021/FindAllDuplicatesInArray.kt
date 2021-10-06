package oct_challenge2021

class FindAllDuplicatesInArray {
    fun findDuplicates(nums: IntArray): List<Int> {
        val set = mutableSetOf<Int>()
        val result = mutableListOf<Int>()
        for (num in nums) {
            if (set.contains(num)) result.add(num)
            set.add(num)
        }
        return result
    }
}