package nov_challenge2021

import common.TreeNode

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)

    val result = SumRootToLeafNumbers().sumNumbers(root)
    assert(result == 25)
    println(result)
}

class SumRootToLeafNumbers {
    private val list = mutableListOf<String>()

    fun sumNumbers(root: TreeNode?): Int {
        traverse(root, StringBuilder())
        return list.sumOf { it.toInt() }
    }

    private fun traverse(node: TreeNode?, builder: StringBuilder) {
        if (node == null) return
        builder.append(node.`val`)
        traverse(node.left, builder)
        traverse(node.right, builder)
        if (node.left == null && node.right == null) {
            list.add(builder.toString())
        }
        builder.deleteCharAt(builder.lastIndex)
    }
}
