package jun_challenge2023

class StraightLine {
    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        if (coordinates.size == 2) return true
        val first = coordinates[0]
        val second = coordinates[1]
        for (i in 2 until coordinates.size) {
            val curr = coordinates[i]
            if ((first[1] - second[1]) * (first[0] - curr[0]) !=
                (first[1] - curr[1]) * (first[0] - second[0])
            ) {
                return false
            }
        }
        return true
    }
}