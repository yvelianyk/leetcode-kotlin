package dec_challenge2021

import common.TreeNode

class RangeSumBST {
    private var result = 0
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        if (root == null) return 0
        if (root.`val` in low .. high) {
            result += root.`val`
        }
        if (root.`val` >= low) {
            rangeSumBST(root.left, low, high)
        }
        if (root.`val` <= high) {
            rangeSumBST(root.right, low, high)
        }
        return result
    }
}