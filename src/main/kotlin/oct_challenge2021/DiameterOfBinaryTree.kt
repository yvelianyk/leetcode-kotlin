package oct_challenge2021

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left!!.left = TreeNode(4)
    root.left!!.right = TreeNode(5)
//    val root = TreeNode(1)
//    root.left = TreeNode(2)
//    root.right= TreeNode(3)
    val result = DiameterOfBinaryTree().diameterOfBinaryTree(root)
    println(result)
}

class DiameterOfBinaryTree {
    private var max = Int.MIN_VALUE

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        getMax(root)
        return max
    }

    private fun getMax(node: TreeNode?): Int {
        if (node == null) return 0
        val left = getMax(node.left)
        val right = getMax(node.right)
        max = maxOf(max, left + right)
        return maxOf(left, right) + 1
    }

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}