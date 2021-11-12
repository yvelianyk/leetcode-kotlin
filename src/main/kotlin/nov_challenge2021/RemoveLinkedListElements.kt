package nov_challenge2021

import common.ListNode

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(6)
    head.next!!.next!!.next = ListNode(3)
    head.next!!.next!!.next!!.next = ListNode(4)
    head.next!!.next!!.next!!.next!!.next = ListNode(5)
    head.next!!.next!!.next!!.next!!.next!!.next = ListNode(6)
    val result = RemoveLinkedListElements().removeElements(head, 6)
    println(result)
}

class RemoveLinkedListElements {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        val dummy = ListNode(-1)
        dummy.next = head
        var next = head
        var prev = dummy
        while (next != null) if (next.`val` == `val`) {
            val nextNext = next.next
            prev.next = nextNext
            next = prev.next
        } else {
            prev = next
            next = next.next
        }
        return dummy.next
    }
}
