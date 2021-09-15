package sep_challenge2021

fun main() {
    val str = "a-bC-dEf-ghIj"
    val reversed = reverseOnlyLetters(str)
    assert(reversed == "j-Ih-gfE-dCba")
    println(reversed)
}

fun reverseOnlyLetters(s: String): String {
    val charArr = s.toCharArray()
    var left = 0
    var right = s.length - 1
    while (left < right) {
        val leftChar = charArr[left]
        val rightChar = charArr[right]
        if (!leftChar.isLetter()) {
            left++
            continue
        }
        if (!rightChar.isLetter()) {
            right--
            continue
        }
        // swap
        charArr[left] = charArr[right].also { charArr[right--] = charArr[left++] }
    }
    return String(charArr)
}