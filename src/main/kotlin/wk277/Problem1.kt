package wk277

class Problem1 {
    fun countElements(nums: IntArray): Int {
        var res = 0
        for (num in nums) {
            var smaller = false
            var bigger = false
            for (inner in nums) {
                if (num < inner) smaller = true
                if (num > inner) bigger = true
            }
            if (smaller && bigger) res++
        }
        return res
    }
}
