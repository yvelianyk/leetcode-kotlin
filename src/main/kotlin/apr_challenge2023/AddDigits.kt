package apr_challenge2023

fun main() {
    val res = AddDigits().addDigits(10)
    println(res)
}

class AddDigits {
    fun addDigits(num: Int): Int {
        var arr = getDigits(num)
        while (arr.size > 1) {
            val sum = arr.sum()
            arr = getDigits(sum)
        }
        return arr[0]
    }

    private fun getDigits(num: Int): IntArray {
        val res = mutableListOf<Int>()
        var resNum = num
        while (resNum >= 10) {
            val ext = resNum / 10
            res.add(resNum / 10)
            resNum -= (ext * 10)
        }
        res.add(resNum)
        return res.toIntArray()
    }
}