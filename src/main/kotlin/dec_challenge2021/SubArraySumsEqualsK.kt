package dec_challenge2021

fun main() {
    val res = SubArraySumsEqualsK().subarraySum(intArrayOf(0, -10, 10, 1, 1, 1), 2)
    println(res)
}

/*
target = 2
0, -10, 10, 1, 1, 1 - original array
0, -10,  0, 1, 2, 3 - prefix sums(rolling) put to the map and count number of occurences


0,  0,  0, 0, 3, 4
              ^ = counter[pref sum - k] = x.
              It should get the number of prefix sums with target k so far.
              The trick is to count all prefix sums in the counter map.
              In this example, we have 3 cases where sum is 2:
              1. 0, -10, 10, 1, 1
              2. -10, 10, 1, 1
              3. 1, 1
              Hence, in the pref sum count map we have 2 - 2 = 0. So we have 0 key in the counter with count 3
              Because we need to start from 0



 */
class SubArraySumsEqualsK {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val counter = mutableMapOf<Int,Int>()
        counter[0] = 1
        var prefSum = 0
        var result = 0
        for (num in nums) {
            prefSum += num
            val currCounter = counter[prefSum - k] ?: 0
            counter[prefSum] = (counter[prefSum] ?: 0) + 1
            result += currCounter
        }
        return result
    }
}