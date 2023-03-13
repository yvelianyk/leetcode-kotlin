package mar_challenge2023

import common.TreeNode

class SymmetricTree {
    fun isSymmetric(root: TreeNode?): Boolean {
        return root?.let {
            return check(root, root)
        } ?: true
    }

    private fun check(node1: TreeNode?, node2: TreeNode?): Boolean {
        if ((node1 == null) and (node2 == null)) return true
        if ((node1 == null) or (node2 == null)) return false
        return check(node1?.left, node2?.right) and
                check(node1?.right, node2?.left) and
                (node1?.`val` == node2?.`val`)
    }
}