package oct_challenge2021

fun main() {
    val grid = arrayOf(
        intArrayOf(0, 1, 0, 0),
        intArrayOf(1, 1, 1, 0),
        intArrayOf(0, 1, 0, 0),
        intArrayOf(1, 1, 0, 0),
    )
    val result = Solution().islandPerimeter(grid)
    assert(result == 16)
    println(result)
}

class Solution {
    private lateinit var grid: Array<IntArray>
    private lateinit var visited: Array<IntArray>
    private val dirs = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
    private var result: Int = 0

    fun islandPerimeter(grid: Array<IntArray>): Int {
        this.grid = grid
        this.visited = Array(grid.size) { IntArray(grid[0].size) { 0 } }
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    traverse(i, j)
                    return result
                }
            }
        }
        return result
    }

    private fun traverse(i: Int, j: Int) {
        val m = grid.size
        val n = grid[0].size
        visited[i][j] = 1
        for (dir in dirs) {
            val newI = i + dir[0]
            val newJ = j + dir[1]
            val canTraverse = newI in 0 until m && newJ in 0 until n && grid[newI][newJ] == 1
            when {
                canTraverse -> {
                    if (visited[newI][newJ] == 0) traverse(newI, newJ)
                }
                else -> {
                    result++
                }
            }
        }
    }

}