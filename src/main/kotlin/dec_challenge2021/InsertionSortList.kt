package dec_challenge2021

import common.ListNode

class InsertionSortList {
    fun insertionSortList(head: ListNode?): ListNode? {
        if (head == null) return null
        val dummy = ListNode(-1)
        var node = head
        while (node != null) {
            var prev: ListNode? = dummy

            while (prev?.next != null && prev.next!!.`val` < node.`val`) {
                prev = prev.next
            }
            val next = node.next
            node.next = prev?.next
            prev?.next = node
            node = next
        }
        return dummy.next
    }
}