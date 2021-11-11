package oct_challenge2021

fun main() {
//    val arr1 = intArrayOf(2,3,1,1,4)
//    assert(canJump(arr1))
//    println(canJump(arr1))

    val arr2 = intArrayOf(3, 2, 1, 0, 4)
    assert(!canJump(arr2))
    println(canJump(arr2))
}

fun canJump(nums: IntArray): Boolean {
    val memo = IntArray(nums.size) { -1 }
    return canStep(0, nums, memo)
}

fun canStep(index: Int, nums: IntArray, memo: IntArray): Boolean {
    if (index >= nums.size - 1) return true
    if (memo[index] != -1) return memo[index] == 1
    val steps = nums[index]
    val maxIndex = minOf(index + steps, nums.size - 1)
    for (step in index + 1..maxIndex) {
        if (canStep(step, nums, memo)) {
            memo[step] = 1
            return true
        }
    }

    memo[index] = 0
    return false
}
