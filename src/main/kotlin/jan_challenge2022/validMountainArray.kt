package jan_challenge2022

fun main() {
//    val res = ValidMountainArray().validMountainArray(intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 0))
//    val res = ValidMountainArray().validMountainArray(intArrayOf(0, 1, 2, 4, 2, 1))
    val res = ValidMountainArray().validMountainArray(intArrayOf(1, 2, 3))
    println(res)
}

class ValidMountainArray {
    fun validMountainArray(arr: IntArray): Boolean {
        if (arr.size < 3) return false
        if (arr[0] > arr[1]) return false
        var isUp = true
        var wasFlip = false
        for (i in 0 until arr.size - 1) {
            val curr = arr[i]
            val next = arr[i + 1]
            if (curr == next) return false
            if (curr > next) {
                if (isUp && wasFlip) return false
                wasFlip = true
                isUp = false
            } else if (wasFlip) return false
        }
        return wasFlip
    }
}
