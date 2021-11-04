package nov_challenge2021

import common.TreeNode

fun main() {
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)

    root.right!!.left = TreeNode(15)
    root.right!!.right = TreeNode(7)
    val res1 = SumOfLeftLeaves().sumOfLeftLeaves(root)
    assert(res1 == 24)

    val res2 = SumOfLeftLeaves().sumOfLeftLeaves(TreeNode(1))
    assert(res2 == 0)
}

class SumOfLeftLeaves {
    fun sumOfLeftLeaves(root: TreeNode?): Int {
        if (root == null) return 0
        var sum = 0
        if (root.left?.right == null && root.left?.left == null) sum += root.left?.`val` ?: 0
        sum += sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right)
        return sum
    }
}
