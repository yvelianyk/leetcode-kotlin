package wk274

fun main() {
    val res = Problem1().checkString("bbb")
    println(res)
}

class Problem1 {
    fun checkString(s: String): Boolean {
        val chars = s.toCharArray()
        var isBApperead = false
        for (char in chars) {
            if (char == 'a') {
                if (isBApperead) return false
            }
            if (char == 'b') isBApperead = true
        }
        return true
    }
}
