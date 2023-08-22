package aug_challenge2023

fun main() {
    val res = ExcelSheetColumnTitle().convertToTitle(1035)
    println(res)
}

class ExcelSheetColumnTitle {
    fun convertToTitle(columnNumber: Int): String {
        var div = columnNumber
        val res = mutableListOf<Char>()
        while (div > 0) {
            val letter = div % 26
            if (letter == 0) res.add('Z') else res += 'A' + letter - 1
            when (letter) {
                0 -> div = div / 26 - 1
                else -> div /= 26
            }
        }
        return String(res.asReversed().toCharArray())
    }
}