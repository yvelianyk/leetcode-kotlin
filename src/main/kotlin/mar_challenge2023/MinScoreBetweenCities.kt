package mar_challenge2023


fun main() {
//    val res = MinScoreBetweenCities().minScore(
//        4,
//        arrayOf(
//            intArrayOf(1, 2, 9),
//            intArrayOf(2, 3, 6),
//            intArrayOf(2, 4, 5),
//            intArrayOf(1, 4, 7)
//        )
//    )
    val res = MinScoreBetweenCities().minScore(
        6,
        arrayOf(
            intArrayOf(4,5,7468),
            intArrayOf(6,2,7173),
            intArrayOf(6,3,8365),
            intArrayOf(2,3,7674),
            intArrayOf(5,6,7852),
            intArrayOf(1,2,8547),
            intArrayOf(1,2,8547),
            intArrayOf(2,4,1885),
            intArrayOf(2,5,5192),
            intArrayOf(1,3,4065),
            intArrayOf(1,4,7357),
        )
    )
    println(res)
}

class MinScoreBetweenCities {

    private val graph = mutableMapOf<Int, MutableList<Point>>()
    private var result = Int.MAX_VALUE
    private val visited = mutableSetOf<Int>()
    fun minScore(n: Int, roads: Array<IntArray>): Int {
        buildGraph(roads)
        bfs(1)
        return result
    }

    private fun bfs(node: Int) {
        if (visited.contains(node)) return
        visited.add(node)
        val children = graph.getOrDefault(node, mutableListOf())
        for (child in children) {
            result = minOf(child.distance, result)

            bfs(child.value)
        }
    }


    private fun buildGraph(edges: Array<IntArray>) {
        for (edge: IntArray in edges) processEdge(edge)
    }

    private fun processEdge(edge: IntArray) {
        val from = edge[0]
        val to = edge[1]
        val distance = edge[2]
        val existingFromEdges = graph.getOrDefault(from, mutableListOf())
        existingFromEdges.add(Point(to, distance))
        graph[from] = existingFromEdges

        val existingToEdges = graph.getOrDefault(to, mutableListOf())
        existingToEdges.add(Point(from, distance))
        graph[to] = existingToEdges
    }

    internal data class Point(val value: Int = -1, val distance: Int = -1)
}