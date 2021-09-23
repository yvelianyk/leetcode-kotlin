package sep_challenge2021

fun main() {
    val str = "aa"
    val res = breakPalindrome(str)
    println(res)
}

fun breakPalindrome(palindrome: String): String {
    if (palindrome.length == 1) return ""
    val charAr = palindrome.toCharArray()
    for (index in charAr.indices) {
        if (charAr[index] == 'a' && index != charAr.size - 1) {
            continue
        }
        val temp = charAr[index]
        var c = 'a'
        while (c <= 'z') {
            charAr[index] = c++;
            if (!isPalindrome(String(charAr))) {
                return String(charAr)
            }
        }
        charAr[index] = temp
    }
    return ""
}

fun isPalindrome(str: String): Boolean {
    var left = 0
    var right = str.length - 1
    while (left < right) {
        if (str[left++] != str[right--]) {
            return false
        }
    }
    return true
}