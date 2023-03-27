package mar_challenge2023

fun main() {
    val result = MinPathSum().minPathSum(
        arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
        )
    )
    println(result)
}

class MinPathSum {
    private lateinit var memo: Array<IntArray>
    private lateinit var grid: Array<IntArray>
    fun minPathSum(grid: Array<IntArray>): Int {
        this.grid = grid
        memo = Array(grid.size) { IntArray(grid[0].size) { -1 } }
        return getMin(0, 0)
    }

    private fun getMin(i: Int, j: Int): Int {
        if (i >= grid.size || j >= grid[0].size) return Int.MAX_VALUE
        if (i == grid.size - 1 && j == grid[0].size - 1) return grid[i][j]
        if (memo[i][j] != -1) return memo[i][j]

        memo[i][j] = grid[i][j] + minOf(getMin(i, j + 1), getMin(i + 1, j))
        return memo[i][j]
    }
}