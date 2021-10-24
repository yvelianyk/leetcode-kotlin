package oct_challenge2021

import common.TreeNode

// Could be solved with better time complexity then O(n)
// In the every step check depth of left and right parts - if they equal - use formula
class CountCompleteTreeNodes {
    fun countNodes(root: TreeNode?): Int {
        return when (root) {
            null -> 0
            else -> 1 + countNodes(root.left) + countNodes(root.right)
        }
    }
}
