package aug_challenge2023

import java.util.*
import kotlin.math.ceil

fun main() {
    val res = ReorganizeString().reorganizeString("a")
    println(res)
}

class ReorganizeString {
    fun reorganizeString(s: String): String {
        val map = s.toCharArray().toList().groupingBy { it }.eachCount() as MutableMap<Char, Int>
        val queue = PriorityQueue<Pair<Char, Int>> { a, b -> b.second - a.second }
        for (entry in map) queue.add(Pair(entry.key, entry.value))

        var res = ""
        while (queue.isNotEmpty()) {
            val last = queue.poll()
            if (res.isEmpty()) {
                res += last.first
                if (last.second - 1 > 0) {
                    queue.add(Pair(last.first, last.second - 1))
                }
            } else {
                val prev = res[res.length - 1]
                if (last.first != prev) {
                    if (last.second == 0) {
                        return ""
                    } else {
                        res += last.first
                        if (last.second - 1 > 0) {
                            queue.add(Pair(last.first, last.second - 1))
                        }
                    }
                } else {
                    if (queue.isEmpty()) {
                        return ""
                    } else {
                        val preLast = queue.poll()
                        res += preLast.first

                        if (preLast.second - 1 > 0) {
                            queue.add(Pair(preLast.first, preLast.second - 1))
                        }
                    }
                    queue.add(Pair(last.first, last.second))
                }
            }
        }
        return res
    }
}