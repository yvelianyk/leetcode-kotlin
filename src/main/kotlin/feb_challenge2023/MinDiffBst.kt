package feb_challenge2023

import common.TreeNode
import kotlin.math.abs

fun main() {
    val tree = TreeNode(1)
    tree.left = TreeNode(0)
    tree.right = TreeNode(48)
    tree.right!!.left = TreeNode(12)
    tree.right!!.right = TreeNode(49)
    val res = MinDiffBst().minDiffInBST(tree)
    println(res)
}

class MinDiffBst {
    private var prev = -1
    private var diff = Int.MAX_VALUE
    fun minDiffInBST(root: TreeNode?): Int {
        traverse(root)
        return diff
    }

    private fun traverse(root: TreeNode?) {
        root?.let {
            traverse(it.left)
            if (prev != -1) {
                diff = minOf(diff, abs(it.`val` - prev))
            }
            prev = it.`val`
            traverse(it.right)
        }
    }
}

