package dec_challenge2021

fun main() {
//    val arr = intArrayOf(3,0,2,1,2)
    val arr = intArrayOf(4, 2, 3, 0, 3, 1, 2)
    val res = JumpGameIII().canReach(arr, 5)
    println(res)
}

class JumpGameIII {
    fun canReach(arr: IntArray, start: Int): Boolean {
        return dfs(start, arr, IntArray(arr.size))
    }

    private fun dfs(current: Int, arr: IntArray, visited: IntArray): Boolean {
        if (current !in arr.indices || visited[current] == 1) return false
        visited[current] = 1
        if (arr[current] == 0) return true
        return dfs(current - arr[current], arr, visited) or dfs(current + arr[current], arr, visited);
    }
}