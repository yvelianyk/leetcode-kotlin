package oct_challenge2022

import common.TreeNode

fun main() {
    val node1 = TreeNode(3)
    val node2 = TreeNode(1)
    val node3 = TreeNode(4)
    node1.left = node2
    node1.right = node3
    val node4 = TreeNode(3)
    val node5 = TreeNode(1)
    val node6 = TreeNode(5)
    node2.left = node4
    node4.left = node5
    node4.right = node6

    val result = GoodNodes().goodNodes(node1)
    println(result)
}

class GoodNodes {
    private var count: Int = 0
    fun goodNodes(root: TreeNode?): Int {
        traverse(root, Int.MIN_VALUE)
        return count
    }

    private fun traverse(node: TreeNode?, max: Int) {
        if (node == null) return
        if (node.`val` >= max) count++
        val newMax = if (node.`val` < max) max else node.`val`
        traverse(node.left, newMax)
        traverse(node.right, newMax)
    }
}