package nov_challenge2021

fun main() {
    val res1 = FindAllNumbersDissappeared().findDisappearedNumbers(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1))
    val res2 = FindAllNumbersDissappeared().findDisappearedNumbers(intArrayOf(1, 1))
    println(res1)
    println(res2)
}

class FindAllNumbersDissappeared {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val result = List(nums.size) { 0 }.toMutableList()
        for (num in nums) result[num - 1] = 1
        return result.mapIndexed { index, i -> if (i == 0) index + 1 else 0 }.filter { it != 0 }
    }
}
