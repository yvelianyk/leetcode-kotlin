package wk270

import common.ListNode

class Problem2 {
    fun deleteMiddle(head: ListNode?): ListNode? {
        if (head!!.next == null) return null
        var size = 0
        var node = head
        while (node != null) {
            size++
            node = node.next
        }
        val middle = size / 2
        var counter = 0
        var beforeMiddle = head
        while (counter != middle - 1) {
            beforeMiddle = beforeMiddle?.next
            counter++
        }
        val middleNode = beforeMiddle?.next
        val nextAfterMiddle = middleNode?.next
        beforeMiddle?.next = nextAfterMiddle
        return head
    }
}