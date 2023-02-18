package feb_challenge2023

import common.TreeNode

fun main() {
    val tree = TreeNode(1)
    tree.left = TreeNode(2)
    tree.right = TreeNode(3)
    val res = InvertBinaryTree().invertTree(tree)
    println(res)
}

class InvertBinaryTree {
    fun invertTree(root: TreeNode?): TreeNode? {
        return root?.let {
            val res = TreeNode(it.`val`)
            res.left = invertTree(it.right)
            res.right = invertTree(it.left)
            return res
        }
    }
}