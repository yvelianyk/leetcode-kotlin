package apr_challenge2023

import common.TreeNode

class LongestZigZagPath {
    private var res = 0
    fun longestZigZag(root: TreeNode?): Int {
        traverse(root, 0, 0)
        return res
    }

    private fun traverse(node: TreeNode?, resultLeft: Int, resultRight: Int) {
        node?.let {
            res = maxOf(res, resultLeft)
            res = maxOf(res, resultRight)
            traverse(node.left, 0, resultLeft + 1)
            traverse(node.right, resultRight + 1, 0)
        }
    }
}