package mar_challenge2023

import common.TreeNode
import java.util.*

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left!!.left = TreeNode(4)
    root.right!!.left = TreeNode(6)
    val res = ComplementBinaryTree().isCompleteTree(root)
    println(res)
}

class ComplementBinaryTree {
    fun isCompleteTree(root: TreeNode?): Boolean {
        val queue = LinkedList<TreeNode?>()
        queue.add(root)
        while (queue.peek() != null) {
            val cur = queue.poll()
            queue.add(cur?.left)
            queue.add(cur?.right)
        }

        while (queue.isNotEmpty() && queue.peek() == null) {
            queue.poll()
        }

        return queue.isEmpty()
    }
}