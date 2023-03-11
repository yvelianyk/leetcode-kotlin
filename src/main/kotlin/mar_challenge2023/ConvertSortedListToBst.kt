package mar_challenge2023

import common.ListNode
import common.TreeNode

fun main() {
    val head = ListNode(-10)
    head.next = ListNode(-3)
    head.next!!.next = ListNode(0)
    head.next!!.next?.next = ListNode(5)
    head.next!!.next?.next?.next = ListNode(9)
    val res = ConvertSortedListToBst().sortedListToBST(head)
    println(res)
}

class ConvertSortedListToBst {
    fun sortedListToBST(head: ListNode?): TreeNode? {
        val list = mutableListOf<Int>()
        var node = head
        while (node != null) {
            list.add(node.`val`)
            node = node.next
        }

        return buildTree(list, 0, list.lastIndex)
    }

    private fun buildTree(list: MutableList<Int>, start: Int, end: Int): TreeNode? {
        if (list.isEmpty() || start > end) return null

        val mid = start + (end - start) / 2
        val node = TreeNode(list[mid])
        node.left = buildTree(list, start, mid - 1)
        node.right = buildTree(list, mid + 1, end)
        return node
    }
}