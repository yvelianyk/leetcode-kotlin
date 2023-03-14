package mar_challenge2023

import common.TreeNode

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    val res = SumRootToLeafNumbers().sumNumbers(root)
}
class SumRootToLeafNumbers {
    private val list = mutableListOf<String>()
    fun sumNumbers(root: TreeNode?): Int {
        traverse(root, "")
        return list.sumOf { it.toInt() }
    }

    private fun traverse(node: TreeNode?, num: String) {
        node?.let {
            val newVal = num + ("" + node.`val`)
            node.left?.let { traverse(node.left, newVal) }
            node.right?.let { traverse(node.right, newVal) }
            if ((node.left == null) and (node.right == null)) list.add(newVal)
        }
    }
}