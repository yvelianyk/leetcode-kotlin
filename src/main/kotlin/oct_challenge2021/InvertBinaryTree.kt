package oct_challenge2021

import common.TreeNode

fun main() {
    val root = TreeNode(4)
    root.left = TreeNode(2)
    root.right = TreeNode(7)
    root.left!!.left = TreeNode(1)
    root.left!!.right = TreeNode(3)
    root.right!!.left = TreeNode(6)
    root.right!!.right = TreeNode(9)

    val inverted = InvertBinaryTree().invertTree(root)
    println(inverted)
}

class InvertBinaryTree {

//    Classic approach
//    fun invertTree(root: TreeNode?): TreeNode? {
//        if (root == null) return null
//        val left = root.left
//        val right = root.right
//        root.left = invertTree(right)
//        root.right = invertTree(left)
//        return root
//    }

    // Kotlin style approach
    fun invertTree(root: TreeNode?): TreeNode? = root?.apply {
        val leftNode = left
        val rightNode = right
        left = invertTree(rightNode)
        right = invertTree(leftNode)
    }
}
