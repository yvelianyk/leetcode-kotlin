package feb_challenge2023

import java.util.*

fun main() {
    val result =
        ShortestPathWithAltColors()
            .shortestAlternatingPaths(
                5,
                arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4)),
                arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 1))
            )

//    val result =
//        ShortestPathWithAltColors()
//            .shortestAlternatingPaths(
//                3,
//                arrayOf(intArrayOf(0, 1), intArrayOf(0, 2)),
//                arrayOf(intArrayOf(1,0))
//            )
    println(result)
}

class ShortestPathWithAltColors {
    private val graph = mutableMapOf<Int, MutableList<Point>>()
    private var graphSize = 0
    private var result = intArrayOf()
    fun shortestAlternatingPaths(n: Int, redEdges: Array<IntArray>, blueEdges: Array<IntArray>): IntArray {
        graphSize = n
        result = IntArray(n) { -1 }
        buildGraph(redEdges, blueEdges)
        bfs()

        return result
    }

    private fun bfs() {
        val visited = mutableSetOf<String>()
        val queue: Queue<Point> = LinkedList()
        queue.add(Point(0, -1))
        visited.add("c-1v0")
        result[0] = 0

        var distance = -1
        while (!queue.isEmpty()) {
            distance++
            val size = queue.size
            for (i in 0 until size) {
                val curr = queue.poll()
                if (result[curr.value] == -1) result[curr.value] = distance
                val children = graph.getOrDefault(curr.value, mutableListOf())
                for (child in children) {
                    val visitedKey = "c${child.color}v${child.value}"
                    if (!visited.contains(visitedKey) and (curr.color != child.color)) {
                        queue.add(child)
                        visited.add(visitedKey)
                    }
                }
            }
        }
    }

    private fun buildGraph(redEdges: Array<IntArray>, blueEdges: Array<IntArray>) {
        for (redEdge: IntArray in redEdges) processEdge(0, redEdge)
        for (blueEdge: IntArray in blueEdges) processEdge(1, blueEdge)
    }

    private fun processEdge(color: Int, edge: IntArray) {
        val from = edge[0]
        val to = edge[1]
        val existingEdges = graph.getOrDefault(from, mutableListOf())
        existingEdges.add(Point(to, color))
        graph[from] = existingEdges
    }

    internal data class Point(val value: Int = -1, val color: Int = -1)
}