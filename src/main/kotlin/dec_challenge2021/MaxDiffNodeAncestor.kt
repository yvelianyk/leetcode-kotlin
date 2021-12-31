package dec_challenge2021

import common.TreeNode
import kotlin.math.abs

fun main() {
    val root = TreeNode(8)
    root.left = TreeNode(3)
    root.right = TreeNode(10)
    root.left!!.left = TreeNode(1)
    root.left!!.right = TreeNode(6)
    root.left!!.right?.left = TreeNode(4)
    root.left!!.right?.right = TreeNode(7)

    root.right!!.right = TreeNode(14)
    root.right!!.right?.left = TreeNode(13)
    val res = MaxDiffNodeAncestor().maxAncestorDiff(root)
    println(res)
}

class MaxDiffNodeAncestor {
    private var result = Int.MIN_VALUE
    fun maxAncestorDiff(root: TreeNode?): Int {
        traverse(root, null)
        return result
    }

    private fun traverse(node: TreeNode?, parent: TreeNode?): Pair<Int, Int> {
        if (node == null) return Pair(parent?.`val` ?: Int.MAX_VALUE, parent?.`val` ?: Int.MIN_VALUE)
        val leftPair = traverse(node.left, node)
        val rightPair = traverse(node.right, node)
        val min = minOf(node.`val`, minOf(leftPair.first, rightPair.first))
        val max = maxOf(node.`val`, maxOf(leftPair.second, rightPair.second))
        val res1 = maxOf(abs(node.`val` - leftPair.first), abs(node.`val` - leftPair.second))
        val res2 = maxOf(abs(node.`val` - rightPair.first), abs(node.`val` - rightPair.second))
        result = maxOf(result, maxOf(res1, res2))
        return Pair(min, max)
    }
}