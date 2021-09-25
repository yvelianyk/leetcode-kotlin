package sep_challenge2021

import java.util.*

fun main() {
    val grid = arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(1, 1, 0),
        intArrayOf(0, 0, 0),
        intArrayOf(0, 1, 1),
        intArrayOf(0, 0, 0),
    )
    val result = shortestPath(grid, 1)
    assert(result == 6)
    println(result)
}

val directions = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, -1), intArrayOf(0, 1))

fun shortestPath(grid: Array<IntArray>, k: Int): Int {
    val m = grid.size
    val n = grid[0].size
    val visited = Array(grid.size) { Array(grid[0].size) { IntArray(grid[0].size * grid.size + 1) } }
    val queue: Queue<IntArray> = LinkedList()
    queue.add(intArrayOf(0, 0, k, 0))
    while (!queue.isEmpty()) {
        val current = queue.poll()
        val i = current[0]
        val j = current[1]
        val currentRemain = current[2]
        val currentDist = current[3]
        if (visited[i][j][currentRemain] == 1) continue
        visited[i][j][currentRemain] = 1
        if (i == m - 1 && j == n - 1) return currentDist
        for (direction in directions) {
            val newI = i + direction[0]
            val newJ = j + direction[1]
            if (newI in 0 until m && newJ in 0 until n) {
                if (grid[newI][newJ] == 1 && currentRemain > 0) {
                    queue.add(intArrayOf(newI, newJ, currentRemain - 1, currentDist + 1))
                } else if (grid[newI][newJ] == 0) {
                    queue.add(intArrayOf(newI, newJ, currentRemain, currentDist + 1))
                }
            }
        }

    }
    return -1
}

