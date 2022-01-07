package jan_challenge2022

fun main() {
    val res = CarPooling().carPooling(
        arrayOf(
            intArrayOf(2,1,5),
            intArrayOf(3,4,7),
        ),
        5
    )
    println(res)
}

class CarPooling {
    fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
        val map = sortedMapOf<Int, Int>()
        for (trip in trips) {
            map[trip[1]] = (map[trip[1]] ?: 0) + trip[0]
            map[trip[2]] = (map[trip[2]] ?: 0) - trip[0]
        }
        var acc = 0
        for (entry in map) {
            acc += entry.value
            if (acc > capacity) return false
        }
        return true
    }
}
