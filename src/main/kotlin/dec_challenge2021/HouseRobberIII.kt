package dec_challenge2021

import common.TreeNode

class HouseRobberIII {
    private var memo: MutableMap<TreeNode, Pair<Int?, Int?>> = mutableMapOf()
    fun rob(root: TreeNode?): Int {
        return getMax(root, false)
    }

    fun getMax(node: TreeNode?, isPrevTaken: Boolean): Int {
        if (node == null) return 0
        if (memo[node] != null) {
            if (isPrevTaken && memo[node]!!.first != null) return memo[node]!!.first!!
            if (!isPrevTaken && memo[node]!!.second != null) return memo[node]!!.second!!
        }
        return if (!isPrevTaken) {
            val takenRes = getMax(node.left, true) + getMax(node.right, true) + node.`val`
            val ignoreRes = getMax(node.left, false) + getMax(node.right, false)
            val best =  maxOf(takenRes, ignoreRes)
            memo[node] = Pair(null, best)
            best
        } else {
            val ignoreNum = getMax(node.left, false) + getMax(node.right, false)
            memo[node] = Pair(ignoreNum, null)
            ignoreNum
        }
    }
}