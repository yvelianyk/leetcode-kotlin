package nov_challenge2021

import common.TreeNode

class DeleteNodeBST {
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) return null
        if (root.`val` == key) {
            if (root.left == null) return root.right
            val predecessor = findPredecessor(root.left!!)
            predecessor.right = root.right
            return root.left
        }
        if (key > root.`val`) {
            root.right = deleteNode(root.right, key)
        } else {
            root.left = deleteNode(root.left, key)
        }

        return root
    }

    private fun findPredecessor(node: TreeNode): TreeNode {
        var tree = node
        while (tree.right != null) {
            tree = tree.right!!
        }
        return tree
    }
}
