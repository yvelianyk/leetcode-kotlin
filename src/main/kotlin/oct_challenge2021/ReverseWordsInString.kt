package oct_challenge2021

fun main() {
    val result = ReverseWordsInString().reverseWords("   the  sky is blue")
    assert(result == "blue is sky the")
    println(result)
}

class ReverseWordsInString {
    fun reverseWords(s: String): String {
        return s.trim().split("\\s+".toRegex()).asReversed().joinToString(separator = " ")
    }
}
