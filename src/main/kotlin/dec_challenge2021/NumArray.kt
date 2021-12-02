package dec_challenge2021

fun main() {
    val obj = NumArray(intArrayOf(-2, 0, 3, -5, 2, -1))
    val res1 = obj.sumRange(0,2);
    val res2 = obj.sumRange(2,5);
    val res3 = obj.sumRange(0,5);
    println()
}

class NumArray(private val nums: IntArray) {
    private var pref: IntArray = IntArray(nums.size)

    init {
        pref[0] = nums[0]
        for (i in 1 until nums.size) {
            pref[i] = pref[i - 1] + nums[i]
        }
    }

    //   ^   ^
    // 1,2,3,4,5
    // 1,3 = 9
    // 1,3,6,10,15
    fun sumRange(left: Int, right: Int): Int {
        return pref[right] - pref[left] + nums[left]
    }

}