package oct_challenge2021

// [2,0,2,1,1,0]
// [2,0,2,1,1,0]
// Count colors 0 - 2, 1 - 2, 2 - 2. Then overwrite the input array in-place

fun main() {
    val array = intArrayOf(2, 0, 2, 1, 1, 0)
    SortColors().sortColors(array)
    println()
}

class SortColors {
    fun sortColors(nums: IntArray) {
        val count = IntArray(3)
        nums.forEach { count[it]++ }
        var index = 0
        count.forEachIndexed { i, freq ->
            repeat(freq) { nums[index++] = i }
        }
    }
}
