package mar_challenge2023

fun main() {
    val res = ZeroFilledSubarrays().zeroFilledSubarray(intArrayOf(1,3,0,0,2,0,0,4))
}

class ZeroFilledSubarrays {
    fun zeroFilledSubarray(nums: IntArray): Long {
        var res = 0L
        var count = 0L
        for (num in nums) {
            if (num == 0) {
                count++
            } else {
                res +=  (count * (count + 1)) / 2
                count = 0
            }
        }
        res +=  (count * (count + 1)) / 2
        return res
    }

}