package wk271


fun main() {
    val res = Problem1().countPoints("G4")
    println(res)
}

class Problem1 {
    fun countPoints(rings: String): Int {
        val chars = rings.toCharArray()
        val map = mutableMapOf<Char, String>()
        var count = 0
        for (i in 0..chars.size step 2) {
            if (i == chars.size) continue
            val color = chars[i]
            val rod = chars[i + 1]
            var current = map.getOrDefault(rod, "");
            val prevNotContain = !(current.contains('R') and current.contains('G') and current.contains('B'))
            current += color
            val contain = (current.contains('R') and current.contains('G') and current.contains('B'))
            if (prevNotContain && contain) count++
            map[rod] = current
        }

        return count
    }
}