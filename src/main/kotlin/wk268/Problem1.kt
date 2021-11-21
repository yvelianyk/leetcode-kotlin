package wk268

import kotlin.math.abs

fun main() {
    val res = Problem1().maxDistance(intArrayOf(0,1))
    println(res)
}
class Problem1 {
    fun maxDistance(colors: IntArray): Int {
        var result = 0
        for (i in colors.indices) {
            for (j in i until colors.size) {
                if (colors[i] != colors[j]) {
                    result = maxOf(result, abs(j - i))
                }
            }
        }
        return result
    }
}
