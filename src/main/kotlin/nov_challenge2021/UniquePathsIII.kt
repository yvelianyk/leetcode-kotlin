package nov_challenge2021

fun main() {
    val grid1 = arrayOf(
        intArrayOf(1, 0, 0, 0),
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 0, 2, -1),
    )
    val res1 = UniquePathsIII().uniquePathsIII(grid1)
    assert(res1 == 2)

    val grid2 = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(2, 0),
    )
    val res2 = UniquePathsIII().uniquePathsIII(grid2)
    assert(res2 == 0)
}

class UniquePathsIII {
    private var result = 0
    private lateinit var visited: Array<IntArray>
    private lateinit var grid: Array<IntArray>
    private var obstaclesCount = 0
    private val dirs = arrayOf(Pair(0, 1), Pair(1, 0), Pair(0, -1), Pair(-1, 0))

    fun uniquePathsIII(grid: Array<IntArray>): Int {
        var startI = 0
        var startJ = 0
        this.grid = grid
        visited = Array(grid.size) {
            IntArray(grid[0].size)
        }

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 1) {
                    startI = i
                    startJ = j
                }
                if (grid[i][j] == -1) {
                    obstaclesCount++
                }
            }
        }
        count(startI, startJ, 0)
        return result
    }

    private fun count(i: Int, j: Int, counter: Int) {
        if (grid[i][j] == 2 && counter == grid.size * grid[0].size - 1 - obstaclesCount) {
            result++
            return
        }
        visited[i][j] = 1
        for (dir in dirs) {
            val newI = i + dir.first
            val newJ = j + dir.second
            if (
                newI >= 0 &&
                newI < grid.size &&
                newJ >= 0 &&
                newJ < grid[0].size &&
                visited[newI][newJ] == 0 &&
                grid[newI][newJ] != -1
            ) {
                count(newI, newJ, counter + 1)
            }
        }
        visited[i][j] = 0
    }
}
