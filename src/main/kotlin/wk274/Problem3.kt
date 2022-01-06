package wk274

import java.util.*

//
fun main() {
    val res = Problem3().asteroidsDestroyed(4, intArrayOf(4, 9, 23, 4))
    println(res)
}

class Problem3 {
        fun asteroidsDestroyed(mass: Int, asteroids: IntArray): Boolean {
        val treeSet = TreeSet<Long>()
        treeSet.addAll(asteroids.map { it.toLong()}.toList())
        var currMass = mass.toLong()
        var floor = treeSet.floor(currMass)?.toLong()
        while (floor != null && floor <= currMass) {
            currMass += floor
            treeSet.remove(floor)
            floor = treeSet.floor(currMass)
        }

        return treeSet.size == 0
    }
//    fun asteroidsDestroyed(mass: Int, asteroids: IntArray): Boolean {
//        asteroids.sort()
//        var currMass = mass.toLong()
//        for (asteroid in asteroids) {
//            if (asteroid <= currMass) {
//                currMass += asteroid
//            } else {
//                return false
//            }
//        }
//        return true
//    }
}
