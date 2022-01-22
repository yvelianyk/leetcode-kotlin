package wk275

class Problem1 {
    fun checkValid(matrix: Array<IntArray>): Boolean {
        val size = matrix.size
        for (ints in matrix) {
            val set = (1..size).toMutableSet()
            for (int in ints) set.remove(int)
            if (set.size != 0) return false
        }
        for (i in 0 until size) {
            val set = (1..size).toMutableSet()
            for (j in 0 until size) {
                set.remove(matrix[j][i])
            }
            if (set.size != 0) return false
        }
        return true
    }
}
