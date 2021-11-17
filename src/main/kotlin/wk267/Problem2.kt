package wk267

import common.ListNode

// could be done using stack and just replace values instead of all this crap
fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(3)
    head.next!!.next!!.next = ListNode(4)
    head.next!!.next!!.next!!.next = ListNode(5)
    val res = Problem2().reverseEvenLengthGroups(head)
    println(res)
}

class Problem2 {
    fun reverseEvenLengthGroups(head: ListNode?): ListNode? {
        if (head == null) return null
        var group = 2
        var node: ListNode? = head
        while (node != null) {
            val actualGroup = countGroup(node.next)
            if (actualGroup >= group) {
                if (group % 2 == 0) {
                    val pair = reverse(node.next, group++) ?: return null
                    node.next = pair.first
                    node = pair.second
                } else {
                    var counter = 0
                    while (node != null && counter++ < group) {
                        node = node.next
                    }
                    group++
                }
            } else {
                if (actualGroup % 2 != 0) return head
                val pair = reverse(node.next, actualGroup) ?: return null
                node.next = pair.first
                node = pair.second
            }
        }
        return head
    }

    private fun countGroup(node: ListNode?): Int {
        if (node == null) return 0
        var new = node
        var count = 0
        while (new != null) {
            count++
            new = new.next
        }
        return count
    }

    private fun reverse(node: ListNode?, number: Int): Pair<ListNode?, ListNode?>? {
        var prev: ListNode? = null
        var current: ListNode? = node
        var next: ListNode?
        var count = 0
        while (current != null && count++ < number) {
            next = current.next
            current.next = prev
            prev = current
            current = next
        }
        var last = prev
        var lastPrev = last
        while (last != null) {
            lastPrev = last
            last = last.next
        }
        lastPrev?.next = current
        return Pair(prev, lastPrev)
    }
}
