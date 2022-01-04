package bk68

import kotlin.math.abs

fun main() {
    val res = CanBeValid().canBeValid("((()(()()))()((()()))))()((()(()", "10111100100101001110100010001001")
    println(res)
}

// TODO: not working version
class CanBeValid {
    fun canBeValid(s: String, locked: String): Boolean {
        val chars = s.toCharArray()
        val lockedArr = locked.toCharArray()
        if (chars.first() == ')' && lockedArr.first() == '1') return false
        if (chars.last() == '(' && lockedArr.last() == '1') return false
        val charsMap = chars.toList().groupingBy { it }.eachCount()
        val numOpen = charsMap['('] ?: 0
        val numClose = charsMap[')'] ?: 0
        val diff = abs(numOpen - numClose)
        if (diff % 2 != 0) return false
        if (numOpen == numClose) return true
        val isOpenBigger = numOpen > numClose
        var count = 0

        for (index in chars.indices) {
            val char = chars[index]
            if (isOpenBigger) {
                if (char == '(' && lockedArr[index] != '1') {
                    count++
                    chars[index] = ')'
                }
            } else {
                if (char == ')' && lockedArr[index] != '1') {
                    count++
                    chars[index] = '('
                }
            }
            if (count == diff / 2) return true
        }
        return false
    }
}