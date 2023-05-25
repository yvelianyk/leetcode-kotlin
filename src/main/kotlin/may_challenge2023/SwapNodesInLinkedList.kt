package may_challenge2023

import common.ListNode

class SwapNodesInLinkedList {
    fun swapNodes(head: ListNode?, k: Int): ListNode? {
        return head?.let {
            var node = head
            var count = 0
            while (node != null) {
                count++
                node = node.next
            }
            node = head
            var count2 = 0
            var prev: ListNode
            var prev2: ListNode
            while (node != null) {
               count2++
                if (count == k - 1) {
                    prev = node
                }
                if (count2 == count - k) {
                    prev2 = node
                }
                node = node.next
            }

            return it
        }

    }
}