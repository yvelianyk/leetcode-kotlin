package dec_challenge2021

import common.TreeNode
import kotlin.math.abs

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    val result = BinaryTreeTilt().findTilt(root)
    println(result)
}

class BinaryTreeTilt {
    private var result = 0
    fun findTilt(root: TreeNode?): Int {
        traverse(root)
        return result
    }
    private fun traverse(root: TreeNode?): Int {
        if (root == null) return 0
        val left = traverse(root.left)
        val right = traverse(root.right)
        result += abs(left - right)
        return root.`val` + left + right
    }
}