package dec_challenge2021

import common.ListNode

fun main() {
    val root = ListNode(1)
    root.next = ListNode(2)
    root.next!!.next = ListNode(3)
    root.next!!.next!!.next = ListNode(4)
    root.next!!.next!!.next!!.next = ListNode(5)
    val result = OddEvenLinkedList().oddEvenList(root)
    println(result)
}

class OddEvenLinkedList {
    fun oddEvenList(head: ListNode?): ListNode? {
        if (head == null) return null
        var node = head
        var odd: ListNode? = ListNode(-1)
        var even: ListNode? = ListNode(-1)
        val dummyOdd = odd
        val dummyEven = even
        var isOdd = true
        while (node != null) {
            if (isOdd) {
                odd?.next = node
                odd = odd?.next
                isOdd = false
            } else {
                even?.next = node
                even = even?.next
                isOdd = true
            }
            node = node.next
        }
        odd!!.next = dummyEven!!.next
        even!!.next = null
        return dummyOdd!!.next
    }
}