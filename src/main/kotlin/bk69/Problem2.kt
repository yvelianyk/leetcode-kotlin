package bk69

import common.ListNode

class Problem2 {
    fun pairSum(head: ListNode?): Int {
        if (head == null) return 0
        val list = mutableListOf<Int>()
        var node = head
        while (node != null) {
            list.add(node.`val`)
            node = node.next
        }
        val middle = list.size / 2 - 1
        var res = 0
        for (i in 0..middle) {
            val op = list.size - 1 - i
            res = maxOf(list[i] + list[op], res)
        }
        return res
    }
}
