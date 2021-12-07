package dec_challenge2021

import common.ListNode
import kotlin.math.pow

fun main() {
    val head = ListNode(1)
    head.next = ListNode(0)
    head.next!!.next = ListNode(1)
    val res = ConvertBinNumberInLinkedList().getDecimalValue(head)
    println(res)
}

// Straightforward arithmetic. Recursion
//class ConvertBinNumberInLinkedList {
//    fun getDecimalValue(head: ListNode?): Int {
//        if (head == null) return 0
//        val list: MutableList<Int> = mutableListOf<Int>()
//        traverse(head, list)
//        var count = 0
//        var result = 0
//        for (i in list) {
//            result += i * ((2).toDouble().pow(count++)).toInt()
//        }
//        return result
//    }
//
//    private fun traverse(head: ListNode?, list: MutableList<Int>) {
//       if (head == null) return
//        traverse(head.next, list)
//        list.add(head.`val`)
//    }
//}

// Bit manipulation
// 1. Get the first bit. For example, linked list is 1 -> 0 -> 1(which is 5 in decimal)
//    First bit is 1
// 2. Shift it to the left by 1 bit
//    1 -> 10
// 3. Apply bitwise or operation for the next bit(next bit is 0)
//    10
//    00
//    --
//    10
// 4. Do the same with next bit and previously calculated result
//    100
//    001
//    ---
//    101 = 5
class ConvertBinNumberInLinkedList {
    fun getDecimalValue(head: ListNode?): Int {
        if (head == null) return 0
        var result = head.`val`
        var node = head.next
        while (node != null) {
            result = (result shl 1) or node.`val`
            node = node.next
        }
        return result
    }
}