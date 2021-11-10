package bk48

fun main() {
    val res = Problem1().secondHighest("aa2111a")
    println(res)
}

class Problem1 {
    fun secondHighest(s: String): Int {
        val array = s.toCharArray().filter {
            it.isDigit()
        }.map {
            Character.getNumericValue(it)
        }.toIntArray().toSet().toIntArray()
        array.sort()
        if (array.size < 2) return -1
        return array[array.size - 2]
    }
}
