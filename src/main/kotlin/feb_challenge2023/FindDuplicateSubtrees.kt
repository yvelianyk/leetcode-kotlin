package feb_challenge2023

import common.TreeNode

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left!!.left = TreeNode(4)
    root.right!!.left = TreeNode(2)
    root.right!!.left?.left = TreeNode(4)
    root.right!!.right = TreeNode(4)
    val res = FindDuplicateSubtrees().findDuplicateSubtrees(root)
    println(res)
}

class FindDuplicateSubtrees {

    private val map = mutableMapOf<String, Int>()
    private val result = mutableListOf<TreeNode?>()
    fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode?> {
        traverse(root)
        return result
    }

    private fun traverse(root: TreeNode?): String {
        root?.let {
            val path = "${root.`val`}->${traverse(root.left)}->${traverse(root.right)}"
            val count = map.getOrDefault(path, 0)
            if (count == 1) result.add(root)
            map[path] = count + 1
            return path
        } ?: run { return "#" }
    }
}