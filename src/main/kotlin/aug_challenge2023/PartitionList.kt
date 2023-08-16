package aug_challenge2023

import common.ListNode

fun main() {
    val list = ListNode(1)
    list.next = ListNode(4)
    list.next!!.next = ListNode(3)
    list.next!!.next?.next = ListNode(2)
    list.next!!.next?.next?.next = ListNode(5)
    list.next!!.next?.next?.next?.next = ListNode(2)
    val res = PartitionList().partition(list, 3)
    println(res)
}

class PartitionList {
    fun partition(head: ListNode?, x: Int): ListNode? {
        val lessDummyNode = ListNode(-1)
        val greaterDummyNode = ListNode(-1)
        var lessNode = lessDummyNode
        var greaterNode = greaterDummyNode
        var node = head
        while (node != null) {
            if (node.`val` >= x) {
                greaterNode.next = ListNode(node.`val`)
                greaterNode = greaterNode.next!!
            } else {
                lessNode.next = ListNode(node.`val`)
                lessNode = lessNode.next!!
            }
            node = node.next
        }
        lessNode.next = greaterDummyNode.next
        return lessDummyNode.next
    }
}