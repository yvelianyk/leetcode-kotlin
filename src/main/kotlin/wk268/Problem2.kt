package wk268

fun main() {
    val res = Problem2().wateringPlants(intArrayOf(7,7,7,7,7,7,7), 8)
    println(res)
}

class Problem2 {
    fun wateringPlants(plants: IntArray, capacity: Int): Int {
        var currCapacity = capacity
        var currSteps = 0
        for (i in plants.indices) {
            if (plants[i] <= currCapacity) {
                currCapacity -= plants[i]
                currSteps++
            } else {
                currSteps += (i + 1) + (i)
                currCapacity = capacity - plants[i]
            }
        }
        return currSteps
    }
}
