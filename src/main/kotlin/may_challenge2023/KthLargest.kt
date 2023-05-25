package may_challenge2023

class KthLargest(private val k: Int, nums: IntArray) {
    private var bst: TreeNodeCnt? = null

    init {
        for (i in nums.indices) {
            val num = nums[i]
            if (bst == null) {
                initBst(num)
            } else {
                addToBst(bst, num)
            }
        }
    }

    private fun initBst(num: Int) {
        bst = TreeNodeCnt(num)
        bst!!.count++
    }

    fun add(`val`: Int): Int {
        if (bst == null) initBst(`val`)
        addToBst(bst, `val`)
        return search(bst, k)
    }

    private fun search(node: TreeNodeCnt?, cnt: Int): Int {
        val leftCount = if (node!!.left == null) 0 else node.left!!.count
        val rightCount = if (node.right == null) 0 else node.right!!.count
        val rightPart = node.count - leftCount
        return if (cnt <= rightCount) {
            search(node.right, cnt)
        } else if (cnt == rightPart) {
            node.`val`
        } else {
            search(node.left, cnt - rightPart)
        }
    }

    private fun addToBst(node: TreeNodeCnt?, `val`: Int): TreeNodeCnt? {
        if (node == null) return null
        val curr: TreeNodeCnt?
        node.count++
        if (`val` < node.`val`) {
            curr = addToBst(node.left, `val`)
            if (curr == null) {
                val newNode = TreeNodeCnt(`val`)
                newNode.count++
                node.left = newNode
            }
        } else {
            curr = addToBst(node.right, `val`)
            if (curr == null) {
                val newNode = TreeNodeCnt(`val`)
                newNode.count++
                node.right = newNode
            }
        }
        return node
    }

    internal inner class TreeNodeCnt(var `val`: Int) {
        var left: TreeNodeCnt? = null
        var right: TreeNodeCnt? = null
        var count = 0
    }
}