package wk270

import common.TreeNode

// TODO:
class Problem3 {
    // Find lowest common ancestor between 2 nodes
    // Then:
    // 1. Climb from start node to LCA
    // 2. Find path from LCA to dest node
    private var lca: TreeNode? = null

    fun getDirections(root: TreeNode?, startValue: Int, destValue: Int): String {
        if (root == null) return ""
        findLCA(root, startValue, destValue)
        return ""
    }

    private fun findLCA(node: TreeNode?, p: Int, q: Int): Boolean {
        if (node == null) return false
        val left = if (findLCA(node.left, p, q)) 1 else 0
        val right = if (findLCA(node.right, p, q)) 1 else 0
        val mid = if (node.`val` == p || node.`val` == q) 1 else 0
        if (left + right + mid >= 2) this.lca = node
        return left + right + mid > 0
    }
}
