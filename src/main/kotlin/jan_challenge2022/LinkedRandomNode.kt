package jan_challenge2022

import common.ListNode
import kotlin.random.Random

class LinkedRandomNode(head: ListNode?) {
    private val list = mutableListOf<Int>()

    init {
        var node = head
        while (node != null) {
            list.add(node.`val`)
            node = node.next
        }
    }

    fun getRandom(): Int {
        return list[Random.nextInt(0, list.size)]
    }
}
