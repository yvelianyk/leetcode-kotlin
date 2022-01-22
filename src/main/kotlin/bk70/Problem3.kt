package bk70

import java.util.*

// [[0,2,0]]
// [2,2]
// [0,1]
// 1
fun main() {
    val res = Problem3().highestRankedKItems(
        arrayOf(
            intArrayOf(0, 2, 0),
        ),
        intArrayOf(2, 2),
        intArrayOf(0, 1),
        1
    )
    println(res)
}

class Problem3 {
    private lateinit var grid: Array<IntArray>
    private lateinit var pricing: IntArray
    private var visitedPoints = mutableListOf<Point>()

    fun highestRankedKItems(grid: Array<IntArray>, pricing: IntArray, start: IntArray, k: Int): List<List<Int>> {
        this.grid = grid
        this.pricing = pricing
        bfs(start[0], start[1])
        return visitedPoints
            .filter {
                it.`val` != 1 && it.`val` >= pricing[0] && it.`val` <= pricing[1]
            }
            .sortedWith(
                compareBy<Point> { it.dist }
                    .thenBy {
                        it.`val`
                    }
                    .thenBy { it.x }
                    .thenBy { it.y }
            )
            .map {
                listOf(it.x, it.y)
            }
            .take(k)
    }

    private fun bfs(i: Int, j: Int) {
        val queue: Queue<Point> =
            LinkedList<Point>()
        val visited = Array(grid.size) {
            BooleanArray(
                grid[0].size
            )
        }

        val directions = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1))

        val first = Point(i, j, 0, grid[i][j])
        queue.add(first)
        visitedPoints.add(first)
        visited[first.x][first.y] = true

        var distance = 0
        while (!queue.isEmpty()) {
            distance++
            val size = queue.size
            for (i in 0 until size) {
                val curr: Point = queue.poll()
                for (direction in directions) {
                    val newPoint =
                        Point(
                            curr.x + direction[0],
                            curr.y + direction[1],
                            distance,
                            0
                        )
                    if (newPoint.x >= 0 && newPoint.x < grid.size && newPoint.y >= 0 && newPoint.y < grid[0].size &&
                        !visited[newPoint.x][newPoint.y] && grid[newPoint.x][newPoint.y] != 0
                    ) {
                        newPoint.`val` = grid[newPoint.x][newPoint.y]
                        visited[newPoint.x][newPoint.y] = true
                        queue.add(newPoint)
                        visitedPoints.add(newPoint)
                    }
                }
            }
        }
    }

    internal class Point(var x: Int, var y: Int, var dist: Int, var `val`: Int)
}
