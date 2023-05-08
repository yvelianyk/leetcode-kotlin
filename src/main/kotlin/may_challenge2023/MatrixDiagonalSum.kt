package may_challenge2023

fun main() {
    val res = MatrixDiagonalSum().diagonalSum(
        arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9),
        )
    )
    println(res)
}

class MatrixDiagonalSum {
    fun diagonalSum(mat: Array<IntArray>): Int {
        var sum = 0
        val last = mat.size - 1
        for (i in 0..last) {
            for (j in 0..last) {
                if (i == j || i == last - j) sum += mat[i][j]
            }
        }
        return sum
    }
}