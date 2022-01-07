package wk274

import java.util.*

//
fun main() {
    val res = Problem3().asteroidsDestroyed(4, intArrayOf(4, 9, 23, 4))
    println(res)
}

class Problem3 {
    fun asteroidsDestroyed(mass: Int, asteroids: IntArray): Boolean {
        asteroids.sort()
        var currMass = mass.toLong()
        for (asteroid in asteroids) {
            if (asteroid <= currMass) {
                currMass += asteroid
            } else {
                return false
            }
        }
        return true
    }
}
