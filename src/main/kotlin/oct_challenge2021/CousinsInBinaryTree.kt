package oct_challenge2021

import common.TreeNode

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left!!.right = TreeNode(4)
    root.right!!.right = TreeNode(5)
    val result = CousinsInBinaryTree().isCousins(root, 5, 4)
    assert(result)
}

class CousinsInBinaryTree {
    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
        val depthX = getDepthWithParent(root, 1, x, -1)
        val depthY = getDepthWithParent(root, 1, y, -1)
        if (depthX == null || depthY == null) return false
        return depthX[0] == depthY[0] && depthX[1] != depthY[1]
    }

    private fun getDepthWithParent(node: TreeNode?, depth: Int, target: Int, parent: Int): IntArray? {
        if (node == null) return null
        if (node.`val` == target) return intArrayOf(depth, parent)
        return getDepthWithParent(node.left, depth + 1, target, node.`val`) ?: getDepthWithParent(
            node.right,
            depth + 1,
            target,
            node.`val`
        )
    }
}
