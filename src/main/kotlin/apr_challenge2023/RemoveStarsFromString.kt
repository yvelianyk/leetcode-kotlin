package apr_challenge2023

import java.util.*

fun main() {
    val res = RemoveStarsFromString().removeStars("leet**cod*e")
    println(res)
}

class RemoveStarsFromString {
    fun removeStars(s: String): String {
        val stack: Stack<Char> = Stack()
        for (char in s) {
            when (char) {
                '*' -> stack.pop()
                else -> stack.push(char)
            }
        }
        return stack.joinToString("")
    }
}