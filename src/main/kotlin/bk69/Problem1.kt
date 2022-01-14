package bk69

fun main() {
    val res = Problem1().capitalizeTitle("capiTalIze tHe titLe")
    println(res)
}

class Problem1 {
    fun capitalizeTitle(title: String): String {
        return title.split(" ").map {
            when (it.length) {
                2, 1 -> {
                    it.toLowerCase()
                }
                else -> {
                    it.toLowerCase().capitalize()
                }
            }
        }.joinToString(separator = " ")
    }
}
