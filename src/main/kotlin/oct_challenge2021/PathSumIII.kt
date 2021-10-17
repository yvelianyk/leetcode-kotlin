package oct_challenge2021

import common.TreeNode

fun main() {
    val root = TreeNode(10)
    root.left = TreeNode(5)
    root.right = TreeNode(-3)
    root.right!!.right = TreeNode(11)
    root.left!!.left = TreeNode(3)
    root.left!!.right = TreeNode(2)
    root.left!!.left?.left = TreeNode(3)
    root.left!!.left?.right = TreeNode(-2)

    root.left!!.right?.right = TreeNode(1)

    val result = PathSumIII().pathSum(root, 8)
    assert(result == 3)
    println(result)
}

class PathSumIII {
    private var targetSum: Int = 0
    private val map = mutableMapOf(0 to 1)

    fun pathSum(root: TreeNode?, targetSum: Int): Int {
        this.targetSum = targetSum
        return traverse(root, 0)
    }

    // traverse + prefix sum + backtracking
    private fun traverse(node: TreeNode?, pathSum: Int): Int {
        if (node == null) return 0
        val current = node.`val` + pathSum
        var res = map[current - targetSum] ?: 0
        map[current] = (map[current] ?: 0) + 1
        res += traverse(node.left, current) + traverse(node.right, current)
        map[current] = map[current]!! - 1
        return res
    }
}
