package apr_challenge2023

import java.util.*


fun main() {
    val res = ValidateStackSequence().validateStackSequences(
        intArrayOf(1, 2, 3, 4, 5),
        intArrayOf(4, 3, 5, 1, 2)
    )
    println(res)
}

class ValidateStackSequence {
    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        var poppedIntex = 0
        val stack = Stack<Int>()
        for (j in pushed) {
            stack.push(j)
            if (j == popped[poppedIntex]) {
                stack.pop()
                poppedIntex++
                if (stack.isEmpty()) continue
                var last = stack.peek()
                var next = popped[poppedIntex]
                while (last == next) {
                    stack.pop()
                    poppedIntex++
                    if (stack.isEmpty()) break
                    last = stack.peek()
                    next = popped[poppedIntex]
                }
            }
        }
        return stack.isEmpty()
    }
}