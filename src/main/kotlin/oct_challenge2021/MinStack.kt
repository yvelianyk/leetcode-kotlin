package oct_challenge2021

import java.util.* // ktlint-disable no-wildcard-imports

fun main() {
    val minStack = MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    val min1 = minStack.getMin()
    assert(min1 == -3)
    minStack.pop()
    val top1 = minStack.top()
    assert(top1 == 0)
    val min2 = minStack.getMin()
    assert(min2 == -2)
}

class MinStack {
    private val stack: Stack<Int> = Stack()
    private val minStack: Stack<Int> = Stack()

    fun push(`val`: Int) {
        if (minStack.isEmpty() || `val` <= minStack.peek()) {
            minStack.push(`val`)
        }

        stack.push(`val`)
    }

    fun pop() {
        if (stack.pop() == minStack.peek()) minStack.pop()
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return minStack.peek()
    }
}
