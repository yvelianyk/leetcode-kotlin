package mar_challenge2023

fun main() {
    val res = CanPlaceFlowers().canPlaceFlowers(intArrayOf(1, 0, 0, 0, 0, 1), 2)
    println(res)
}

class CanPlaceFlowers {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var count = n
        for (i in flowerbed.indices) {
            val prev = if (i == 0) 0 else flowerbed[i - 1]
            val next = if (i == flowerbed.size - 1) 0 else flowerbed[i + 1]
            val curr = flowerbed[i]
            if ((prev == 0) and (curr == 0) and (next == 0)) {
                flowerbed[i] = 1
                count--
            }
        }
        return count <= 0
    }
}