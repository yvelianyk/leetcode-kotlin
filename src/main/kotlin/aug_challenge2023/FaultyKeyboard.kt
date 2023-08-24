package aug_challenge2023

class FaultyKeyboard {
    fun finalString(s: String): String {
        var res = ""
        for (c in s) {
            if (c == 'i') {
                res = res.reversed()
            } else {
                res += c
            }
        }
        return res
    }
}